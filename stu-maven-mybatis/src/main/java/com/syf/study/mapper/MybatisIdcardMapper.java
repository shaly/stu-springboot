package com.syf.study.mapper;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.cache.decorators.LruCache;

import com.syf.study.bean.MybatisIdcard;
@CacheNamespace(eviction=LruCache.class,flushInterval=3000,size=512)
public interface MybatisIdcardMapper {
	
	public MybatisIdcard queryById(Integer id);

}
