/**   
 * Copyright © 2019 公司名. All rights reserved.
 * 
 * @Title: ESUtils.java 
 * @Prject: chengongjun_cms
 * @Package: com.chengongjun.chengongjun_cms.utils 
 * @Description: TODO
 * @author: chj   
 * @date: 2019年7月24日 上午10:14:13 
 * @version: V1.0   
 */
package com.houyuli.common.utils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightField;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.SearchResultMapper;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.aggregation.impl.AggregatedPageImpl;
import org.springframework.data.elasticsearch.core.query.GetQuery;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.data.elasticsearch.core.query.IndexQueryBuilder;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

/**
 * @ClassName: ESUtils
 * @Description: TODO
 * @author:
 * @date: 2019年7月24日 上午10:14:13
 */
public class HLUtils {

	/**
	 * 保存及更新方法
	 * 
	 * @param elasticsearchTemplate
	 * @param id
	 * @param object
	 */
	public static void saveObject(ElasticsearchTemplate elasticsearchTemplate, String id, Object object) {
		// 创建所以对象
		IndexQuery query = new IndexQueryBuilder().withId(id).withObject(object).build();
		// 建立索引
		elasticsearchTemplate.index(query);
	}

	/**
	 * 批量删除
	 * 
	 * @param elasticsearchTemplate
	 * @param clazz
	 * @param ids
	 */
	public static void deleteObject(ElasticsearchTemplate elasticsearchTemplate, Class<?> clazz, Integer ids[]) {
		for (Integer id : ids) {
			// 建立索引
			elasticsearchTemplate.delete(clazz, id + "");
		}
	}

	/**
	 * 
	 * @Title: selectById
	 * @Description: 根据id在es服务启中查询对象
	 * @param elasticsearchTemplate
	 * @param clazz
	 * @param id
	 * @return
	 * @return: Object
	 */
	public static Object selectById(ElasticsearchTemplate elasticsearchTemplate, Class<?> clazz, Integer id) {
		GetQuery query = new GetQuery();
		query.setId(id + "");
		return elasticsearchTemplate.queryForObject(query, clazz);
	}

	// 查询操作
	/**
	 * 
	 * @param elasticsearchTemplate es的模板对象
	 * @param clazz                 实体类的clazz对象
	 * @param pageNum               当前页
	 * @param pageSize              每页条数
	 * @param fieldNames            查询的字段[参数是数组]
	 * @param value                 查询的内容
	 * @return
	 */
	public static <T> PageInfo<T> findByHighLight(ElasticsearchTemplate elasticsearchTemplate, Class<T> clazz,
			Integer pageNum, Integer pageSize, String fieldNames[], String value) {
		AggregatedPage<T> aggregatedPage = null;
		PageInfo<T> pageInfo = new PageInfo<>();

		// 创建Pageable对象 主键的实体类属性名
		final Pageable pageable = PageRequest.of(pageNum - 1, pageSize, Sort.by(Sort.Direction.ASC, "id"));
		// 查询对象
		SearchQuery query = null;
		// 查询条件高亮的构建对象
		QueryBuilder queryBuilder = null;

		if (value != null && !"".equals(value)) {
			// 高亮拼接的前缀与后缀
			String preTags = "<font color=\"red\">";
			String postTags = "</font>";

			// 定义创建高亮的构建集合对象
			HighlightBuilder.Field highlightFields[] = new HighlightBuilder.Field[fieldNames.length];

			for (int i = 0; i < fieldNames.length; i++) {
				// 这个代码有问题
				highlightFields[i] = new HighlightBuilder.Field(fieldNames[i]).preTags(preTags).postTags(postTags);
			}

			// 创建queryBuilder对象
			queryBuilder = QueryBuilders.multiMatchQuery(value, fieldNames);
			query = new NativeSearchQueryBuilder().withQuery(queryBuilder).withHighlightFields(highlightFields)
					.withPageable(pageable).build();
			// elasticsearchTemplate.queryForPage(query, clazz,)

			aggregatedPage = elasticsearchTemplate.queryForPage(query, clazz, new SearchResultMapper() {

				public <T> AggregatedPage<T> mapResults(SearchResponse response, Class<T> clazz, Pageable pageable1) {

					List<T> content = new ArrayList<T>();
					long total = 0l;

					try {
						// 查询结果
						SearchHits hits = response.getHits();
						if (hits != null) {
							// 获取总记录数
							total = hits.getTotalHits();
							// 获取结果数组
							SearchHit[] searchHits = hits.getHits();
							// 判断结果
							if (searchHits != null && searchHits.length > 0) {
								// 遍历结果
								for (int i = 0; i < searchHits.length; i++) {
									// 对象值
									T entity = clazz.newInstance();

									// 获取具体的结果
									SearchHit searchHit = searchHits[i];

									// 获取对象的所有的字段
									Field[] fields = clazz.getDeclaredFields();

									// 遍历字段对象
									for (int k = 0; k < fields.length; k++) {
										// 获取字段对象
										Field field = fields[k];
										// 暴力反射
										field.setAccessible(true);
										// 字段名称
										String fieldName = field.getName();
										if (!fieldName.equals("serialVersionUID") && !fieldName.equals("user")
												&& !fieldName.equals("channel") && !fieldName.equals("category")
												&& !fieldName.equals("articleType") && !fieldName.equals("imgList")) {
											HighlightField highlightField = searchHit.getHighlightFields()
													.get(fieldName);
											if (highlightField != null) {
												// 高亮 处理 拿到 被<font color='red'> </font>结束所包围的内容部分
												String value = highlightField.getFragments()[0].toString();
												// 注意一下他是否是 string类型
												field.set(entity, value);
											} else {
												// 获取某个字段对应的 value值
												Object value = searchHit.getSourceAsMap().get(fieldName);
												// 获取字段的类型
												Class<?> type = field.getType();
												if (type == Date.class) {
													// bug
													if (value != null) {
														field.set(entity, new Date(Long.valueOf(value + "")));
													}
												} else {
													field.set(entity, value);
												}
											}
										}
									}

									content.add(entity);
								}
							}
						}
					} catch (Exception e) {
						e.printStackTrace();
					}

					return new AggregatedPageImpl<T>(content, pageable, total);
				}
			});

		} else {
			// 没有查询条件的的时候，获取es中的全部数据 分页获取
			query = new NativeSearchQueryBuilder().withPageable(pageable).build();
			aggregatedPage = elasticsearchTemplate.queryForPage(query, clazz);
		}

		// 创建page对象
		Page<T> page_list = new Page<T>(pageNum, pageSize);

		// 加入当前页的数据，从es中获取当前页的数据
		page_list.addAll(aggregatedPage.getContent());

		// 设置总条数，从es中获取
		page_list.setTotal(aggregatedPage.getTotalElements());

		// 封装到对象中
		pageInfo = new PageInfo<>(page_list);

		return pageInfo;
	}

}
