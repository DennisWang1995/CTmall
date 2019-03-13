package com.CTmall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.CTmall.mapper.TbItemMapper;
import com.CTmall.pojo.TbItem;
import com.CTmall.pojo.TbItemExample;
import com.CTmall.pojo.TbItemExample.Criteria;
import com.CTmall.service.ItemService;

/***
 * 商品管理service
 * @author Dennis
 *
 */
@Service
public class itemServiceImpl implements ItemService {
	@Autowired
	private TbItemMapper tbItemMapper;
	@Override
	public TbItem getItemById(long itemId) {
		//TbItem item = tbItemMapper.selectByPrimaryKey(itemId);
		TbItemExample example = new TbItemExample();
		Criteria criteria = example.createCriteria();
		criteria.andIdEqualTo(itemId);
		List<TbItem> list = tbItemMapper.selectByExample(example);
		if(list!=null&&list.size()>0) {
			return list.get(0);
		}
		return null;
	}

}
