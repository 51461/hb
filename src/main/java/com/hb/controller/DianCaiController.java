package com.hb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hb.common.SysResult;
import com.hb.pojo.CaiDanPojo;
import com.hb.service.DianCanService;
import com.hb.service.LeiService;
import com.hb.service.XiangQingService;

@Controller
public class DianCaiController {
	@Autowired
	private DianCanService dianCanService;
	@Autowired
	private XiangQingService xiangQingService;
	@Autowired
	private LeiService leiService;

	//根据当前商品的销售量排行显示出当前的排名的数量
	@RequestMapping("dodiancan")
	@ResponseBody
	public SysResult findPaiMing() {
		try {
			List<CaiDanPojo> paiMing = dianCanService.findPaiMing();
			return SysResult.ok(paiMing);
		} catch (Exception e) {
			e.printStackTrace();
			return SysResult.fail();
		}

	}
	//根据当前点击的商品显示出当前商品的详情
		@RequestMapping("doxiangqing")
		@ResponseBody
		public SysResult findxiangqing(Integer caiDanId) {
			try {
				CaiDanPojo paiMing = xiangQingService.findxiangqing(caiDanId);
				System.out.println("aaa");
				return SysResult.ok(paiMing);
			} catch (Exception e) {
				e.printStackTrace();
				return SysResult.fail();
			}

		}
		
		//根据菜品类型找菜
				@RequestMapping("findLei")
				@ResponseBody
				public SysResult findLei(Integer caiPinLeiXing) {
					try {
						List<CaiDanPojo> paiMing = leiService.findLei(caiPinLeiXing);
						System.out.println(SysResult.ok(paiMing));
						return SysResult.ok(paiMing);
					} catch (Exception e) {
						e.printStackTrace();
						return SysResult.fail();
					}

				}
}