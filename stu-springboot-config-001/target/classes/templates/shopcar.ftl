<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>我的购物车列表</title>
		<link rel="stylesheet" type="text/css" href="css/base.css">
		<link rel="stylesheet" type="text/css" href="css/tpshop.css">

		<style>
			.coupon_whether {
				overflow: auto;
				height: 500px;
				width: 400px;
			}
		</style>
	</head>

	<body>
		<div class="tpshop-tm-hander p" style="border-bottom: 0;">
			<div class="top-hander" moduleid="1539923">
				<div class="w1224 clearfix">
					<div class="fl">
						<div class="ls-dlzc fl nologin">
							<a href="/Home/user/login.html">Hi,请登录</a>
							<a class="red" href="/Home/user/reg.html">免费注册</a>
						</div>

						<script>
							$(function() {
								var uname = getCookie('uname');
								if(uname == '') {
									$('.islogin').remove();
									$('.nologin').show();
								} else {
									$('.nologin').remove();
									$('.islogin').show();
									$('.userinfo').html(decodeURIComponent(uname).substring(0, 11));
								}
							})
						</script>
					</div>
					<ul class="top-ri-header fr clearfix">
						<li>
							<a target="_blank" href="/Home/Order/order_list.html">我的订单</a>
						</li>
						<li class="spacer"></li>
						<li>
							<a target="_blank" href="/Home/User/visit_log.html">我的浏览</a>
						</li>
						<li class="spacer"></li>
						<li>
							<a target="_blank" href="/Home/User/goods_collect.html">我的收藏</a>
						</li>
						<li class="spacer"></li>
						<li>客户服务</li>
						<li class="spacer"></li>
						<li class="hover-ba-navdh">
							<div class="nav-dh">
								<span>网站导航</span>
								<i class="share-a_a1"></i>
							</div>
							<ul class="conta-hv-nav clearfix">
								<li>
									<a href="/Home/Activity/promoteList.html">优惠活动</a>
								</li>
								<li>
									<a href="/Home/Activity/pre_sell_list.html">预售活动</a>
								</li>
								<li>
									<a href="/Home/Goods/integralMall.html">兑换中心</a>
								</li>
							</ul>
						</li>
					</ul>
				</div>
			</div>
			<div class="nav-middan-z p tphsop2_0">
				<div class="header w1224">
					<div class="ecsc-logo fon_gwcshcar">
						<a href="/" class="logo">
							<img src="http://demo5.tp-shop.cn/public/upload/logo/2018/04-09/814d7e9a0eddcf3754f2e8373a50a19c.png" style="max-width: 240px;max-height: 80px;">
						</a>
					</div>
					<div class="ecsc-search mycarlist_search">
						<form id="sourch_form" name="sourch_form" method="post" action="/Home/Goods/search.html" class="ecsc-search-form">
							<input autocomplete="off" name="q" id="q" type="text" value="" placeholder="搜索关键字" class="ecsc-search-input">
							<button type="submit" class="ecsc-search-button" onclick="if($.trim($('#q').val()) != '') $('#sourch_form').submit();">搜索</button>
							<div class="candidate p">
								<ul id="search_list"></ul>
							</div>
							<script type="text/javascript">
								;
								(function($) {
									$.fn.extend({
										donetyping: function(callback, timeout) {
											timeout = timeout || 1e3;
											var timeoutReference,
												doneTyping = function(el) {
													if(!timeoutReference) return;
													timeoutReference = null;
													callback.call(el);
												};
											return this.each(function(i, el) {
												var $el = $(el);
												$el.is(':input') && $el.on('keyup keypress', function(e) {
													if(e.type == 'keyup' && e.keyCode != 8) return;
													if(timeoutReference) clearTimeout(timeoutReference);
													timeoutReference = setTimeout(function() {
														doneTyping(el);
													}, timeout);
												}).on('blur', function() {
													doneTyping(el);
												});
											});
										}
									});
								})(jQuery);

								$('.ecsc-search-input').donetyping(function() {
									search_key();
								}, 500).focus(function() {
									var search_key = $.trim($('#q').val());
									if(search_key != '') {
										$('.candidate').show();
									}
								});
								$('.candidate').mouseleave(function() {
									$(this).hide();
								});

								function searchWord(words) {
									$('#q').val(words);
									$('#sourch_form').submit();
								}

								function search_key() {
									var search_key = $.trim($('#q').val());
									if(search_key != '') {
										$.ajax({
											type: 'post',
											dataType: 'json',
											data: {
												key: search_key
											},
											url: "/Home/Api/searchKey.html",
											success: function(data) {
												if(data.status == 1) {
													var html = '';
													$.each(data.result, function(n, value) {
														html += '<li onclick="searchWord(\'' + value.keywords + '\');"><div class="search-item">' + value.keywords + '</div><div class="search-count">约' + value.goods_num + '个商品</div></li>';
													});
													html += '<li class="close"><div class="search-count">关闭</div></li>';
													$('#search_list').empty().append(html);
													$('.candidate').show();
												} else {
													$('#search_list').empty();
												}
											}
										});
									}
								}
							</script>
						</form>
						<div class="keyword">
							<a class="key-item" href="/Home/Goods/search/q/%E6%89%8B%E6%9C%BA.html" target="_blank">手机</a>
							<a class="key-item" href="/Home/Goods/search/q/%E5%B0%8F%E7%B1%B3.html" target="_blank">小米</a>
							<a class="key-item" href="/Home/Goods/search/q/iphone.html" target="_blank">iphone</a>
							<a class="key-item" href="/Home/Goods/search/q/%E4%B8%89%E6%98%9F.html" target="_blank">三星</a>
							<a class="key-item" href="/Home/Goods/search/q/%E5%8D%8E%E4%B8%BA.html" target="_blank">华为</a>
							<a class="key-item" href="/Home/Goods/search/q/%E5%86%B0%E7%AE%B1.html" target="_blank">冰箱</a>
						</div>
					</div>
				</div>
			</div>
			<div class="w1224">
				<div class="cont_aloinfon">
					<i class="tit_sad"></i>
					<span class="nitp">您还没有登录！登录后购物车的商品将保存在您的账号中</span>
					<a class="loging_ex" href="/Home/User/login.html">立即登录</a>
				</div>
			</div>
		</div>
		<div class="shopcar_empty" style="display: none">
			<div class="w1224">
				<div class="cart-empty">
					<div class="message">
						<ul>
							<li class="txt nologin">
								购物车内暂时没有商品，登录后将显示您之前加入的商品
							</li>

							<li class="mt10" style="padding-left: 100px;">
								<a href="/Home/User/login.html" class="btn-1 login-btn nologin">登录</a>&nbsp;&nbsp;&nbsp;&nbsp;

							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<div id="tpshop-cart">
			<div class="li3_address w1224 p">
				<ul>
					<li class="current">
						<a>全部商品数<em>（4）</em></a>
					</li>
				</ul>
			</div>
			<div class="shoplist_deta p">
				<div class="w1224">
					<div class="cart-thead p">
						<div class="column cart-checkbox">
							<input class="check-box" name="checkboxes" type="checkbox" style="display: none;" checked="checked">
							<i class="checkall checkFull checkall-true"></i>全选
						</div>
						<div class="column t-goods">商品</div>
						<div class="column t-props"></div>
						<div class="column t-price">单价</div>
						<div class="column t-quantity">数量</div>
						<div class="column t-sum">小计</div>
						<div class="column t-action">操作</div>
					</div>
				</div>
			</div>
			<div class="shoplist_detail_a">
				<div class="w1224">
					<div id="edge_1">
						<div class="item-single p">
							<div class="breadth_phase">
								<div class="column ">
									<input class="check-box" name="checkItem" value="1" type="checkbox" checked="checked" style="display: none;">
									<i data-goods-id="129" data-goods-cat-id3="190" data-cart-id="1" class="checkall checkItem checkall-true"></i>
									<img class="msp_picture" src="http://demo5.tp-shop.cn/public/upload/goods/thumb/129/goods_thumb_129_82_82.png">
								</div>
								<div class="column t-goods">
									<p class="msp_spname">
										<a href="/Home/Goods/goodsInfo/id/129.html">优洛莎 2018夏季新款时尚百搭蕾丝镂空针织拼接显瘦上衣P4717</a>
									</p>
									<div class="msp_return">
									</div>
								</div>
							</div>
							<div class="column t-props he87 stang">
							</div>
							<div class="column t-price">
								<span id="cart_1_goods_price">￥88.00</span>
							</div>
							<div class="column t-quantity mtp quantity-form">
								<a href="javascript:void(0);" class="decrement" id="decrement_1">-</a>
								<input name="changeQuantity_1" type="text" id="changeQuantity_1" value="2">
								<a href="javascript:void(0);" class="increment" id="increment_1">+</a>
							</div>
							<div class="column t-sum sumpri">
								<span id="cart_1_total_price">￥176.00</span>
							</div>
							<div class="column t-action">
								<p>
									<a href="javascript:void(0);" class="deleteGoods deleteItem" data-goodsid="129" data-cart-id="1">
										删除</a>
								</p>
								<p>
									<a class="moveCollect collectItem" data-id="129">移到我的收藏</a>
								</p>
							</div>
						</div>
					</div>
					<div id="edge_2">
						<div class="item-single p">
							<div class="breadth_phase">
								<div class="column ">
									<input class="check-box" name="checkItem" value="2" type="checkbox" checked="checked" style="display: none;">
									<i data-goods-id="209" data-goods-cat-id3="389" data-cart-id="2" class="checkall checkItem checkall-true"></i>
									<img class="msp_picture" src="http://demo5.tp-shop.cn/public/upload/goods/thumb/209/goods_thumb_209_82_82.png">
								</div>
								<div class="column t-goods">
									<p class="msp_spname">
										<a href="/Home/Goods/goodsInfo/id/209.html">九阳（Joyoung）豆浆机破壁免滤预约1300ml家用全自动多功能DJ13E-Q1</a>
									</p>
									<div class="msp_return">
									</div>
								</div>
							</div>
							<div class="column t-props he87 stang">
							</div>
							<div class="column t-price">
								<span id="cart_2_goods_price">￥499.00</span>
							</div>
							<div class="column t-quantity mtp quantity-form">
								<a href="javascript:void(0);" class="decrement disable" id="decrement_2">-</a>
								<input name="changeQuantity_2" type="text" id="changeQuantity_2" value="1">
								<a href="javascript:void(0);" class="increment" id="increment_2">+</a>
							</div>
							<div class="column t-sum sumpri">
								<span id="cart_2_total_price">￥499.00</span>
							</div>
							<div class="column t-action">
								<p>
									<a href="javascript:void(0);" class="deleteGoods deleteItem" data-goodsid="209" data-cart-id="2">
										删除</a>
								</p>
								<p>
									<a class="moveCollect collectItem" data-id="209">移到我的收藏</a>
								</p>
							</div>
						</div>
					</div>
					<div id="edge_3">
						<div class="item-single p">
							<div class="breadth_phase">
								<div class="column ">
									<input class="check-box" name="checkItem" value="3" type="checkbox" checked="checked" style="display: none;">
									<i data-goods-id="206" data-goods-cat-id3="381" data-cart-id="3" class="checkall checkItem checkall-true"></i>
									<img class="msp_picture" src="http://demo5.tp-shop.cn/public/upload/goods/thumb/206/goods_thumb_206_82_82.png">
								</div>
								<div class="column t-goods">
									<p class="msp_spname">
										<a href="/Home/Goods/goodsInfo/id/206.html">TCL 118升 小型双门电冰箱 LED照明 迷你节能 办公居家便捷之选 环保内胆 （芭蕾白）BCD-118KA9</a>
									</p>
									<div class="msp_return">
									</div>
								</div>
							</div>
							<div class="column t-props he87 stang">
							</div>
							<div class="column t-price">
								<span id="cart_3_goods_price">￥769.00</span>
							</div>
							<div class="column t-quantity mtp quantity-form">
								<a href="javascript:void(0);" class="decrement disable" id="decrement_3">-</a>
								<input name="changeQuantity_3" type="text" id="changeQuantity_3" value="1">
								<a href="javascript:void(0);" class="increment" id="increment_3">+</a>
							</div>
							<div class="column t-sum sumpri">
								<span id="cart_3_total_price">￥769.00</span>
							</div>
							<div class="column t-action">
								<p>
									<a href="javascript:void(0);" class="deleteGoods deleteItem" data-goodsid="206" data-cart-id="3">
										删除</a>
								</p>
								<p>
									<a class="moveCollect collectItem" data-id="206">移到我的收藏</a>
								</p>
							</div>
						</div>
					</div>
					<div id="edge_4">
						<div class="item-single p">
							<div class="breadth_phase">
								<div class="column ">
									<input class="check-box" name="checkItem" value="4" type="checkbox" checked="checked" style="display: none;">
									<i data-goods-id="204" data-goods-cat-id3="376" data-cart-id="4" class="checkall checkItem checkall-true"></i>
									<img class="msp_picture" src="http://demo5.tp-shop.cn/public/upload/goods/thumb/204/goods_thumb_204_82_82.png">
								</div>
								<div class="column t-goods">
									<p class="msp_spname">
										<a href="/Home/Goods/goodsInfo/id/204.html">海尔（Haier)6公斤干衣机 大烘干量 GDZE6-1W</a>
									</p>
									<div class="msp_return">
									</div>
								</div>
							</div>
							<div class="column t-props he87 stang">
							</div>
							<div class="column t-price">
								<span id="cart_4_goods_price">￥1399.00</span>
							</div>
							<div class="column t-quantity mtp quantity-form">
								<a href="javascript:void(0);" class="decrement disable" id="decrement_4">-</a>
								<input name="changeQuantity_4" type="text" id="changeQuantity_4" value="1">
								<a href="javascript:void(0);" class="increment" id="increment_4">+</a>
							</div>
							<div class="column t-sum sumpri">
								<span id="cart_4_total_price">￥1399.00</span>
							</div>
							<div class="column t-action">
								<p>
									<a href="javascript:void(0);" class="deleteGoods deleteItem" data-goodsid="204" data-cart-id="4">
										删除</a>
								</p>
								<p>
									<a class="moveCollect collectItem" data-id="204">移到我的收藏</a>
								</p>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div class="shoplist_deta floatflex">
				<div class="w1224">
					<div class="edge_tw_foot">
						<div class="item-single p">
							<div class="breadth_phase vermidd">
								<div class="column">
									<input class="check-box" name="checkboxes" type="checkbox" style="display: none;" checked="checked">
									<i class="checkall checkFull checkall-true"></i> 全选
									<a class="mal18 deleteGoods deleteAll" href="javascript:void(0);">删除选中的商品</a>
									<a class="mal18 moveCollect collectAll">移到我的收藏</a>
								</div>
							</div>
							<div class="row_foot_last">
								<div class="column t-quantity">
									<span class="chosewell chosew-add">已选择<em id="goods_num">5</em>件商品</span>
								</div>
								<div class="column widallr">
									<div class="butpayin">
										<a class="paytotal" href="javascript:void(0)" data-url="/Home/Cart/cart2.html">去结算</a>
									</div>
									<div class="totalprice">
										<span class="car_sumprice">总价：<em id="total_fee">￥2843.00</em><i class="bulb"></i></span>
										<div class="price-tipsbox">
											<div class="ui-tips-main">不含运费及送装服务费</div>
											<span class="price-tipsbox-arrow"></span>
										</div>
										<span class="car_conta">已节省：<em id="goods_fee">-￥0.00</em></span>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<script type="text/javascript">
				//去结算旁边的小图标
				$(function() {
					$('.bulb').hover(function() {
						$('.price-tipsbox').show();
					}, function() {
						$('.price-tipsbox').hide();
					})
				})
				//购物车商品高度超过屏幕时去结算浮动
				$(function() {
					var wi = $(window).height();
					var ff = $('.floatflex').offset().top - wi;
					if(wi > ff) {
						$('.floatflex').removeClass('fdix');
					} else {
						$('.floatflex').addClass('fdix');
					}
					$(window).scroll(function() {
						var scr = $(document).scrollTop()
						if(scr > ff) {
							$('.floatflex').removeClass('fdix');
						} else {
							$('.floatflex').addClass('fdix');
						}
					});
				})
				$(document).ready(function() {
					initDecrement();
					initCheckBox();
				});
			</script>
		</div>
		<div class="shoplist_guess">
			<div class="w1224">
				<div class="main_shopcarlist">
					<div class="li3_address folahov p">
						<ul>
							<li class="current" data-id="guess-products">
								<a href="javascript:void(0);">猜你喜欢</a>
							</li>
							<li data-id="collect-products">
								<a href="javascript:void(0);">我的收藏</a>
							</li>
							<li data-id="history-products">
								<a href="javascript:void(0);">最近浏览</a>
							</li>
						</ul>
					</div>
					<div class="totalswitch">
						<div class="switchable-panel" id="guess-products">
							<div class="goods-list-tab">
								<a class="s-item curr">&nbsp;</a>
								<a class="s-item">&nbsp;</a>
								<a class="s-item">&nbsp;</a>
							</div>
							<div class="s-panel-main">
								<div class="goods-panel jsaddsucc p">
									<ul>
										<li>
											<div class="itemgoodbox">
												<div class="p-img">
													<a target="_blank" href="/Home/Goods/goodsInfo/id/211.html">
														<img src="http://demo5.tp-shop.cn/public/upload/goods/thumb/211/goods_thumb_211_160_160.png">
													</a>
												</div>
												<div class="p-name">
													<a target="_blank" href="/Home/Goods/goodsInfo/id/211.html">绿鲜知 鲜香椿 香椿芽 约150g 新鲜蔬菜</a>
												</div>
												<div class="p-price">
													<strong><em>￥</em><i>23.90</i></strong>
												</div>
												<div class="p-btn-adc">
													<a onclick="javascript:AjaxAddCart(211,1);" class="btn-append"><b></b>加入购物车</a>
												</div>
											</div>
										</li>
										<li>
											<div class="itemgoodbox">
												<div class="p-img">
													<a target="_blank" href="/Home/Goods/goodsInfo/id/209.html">
														<img src="http://demo5.tp-shop.cn/public/upload/goods/thumb/209/goods_thumb_209_160_160.png">
													</a>
												</div>
												<div class="p-name">
													<a target="_blank" href="/Home/Goods/goodsInfo/id/209.html">九阳（Joyoung）豆浆机破壁免滤预约1300ml家用全自动多功能DJ13E-Q1</a>
												</div>
												<div class="p-price">
													<strong><em>￥</em><i>499.00</i></strong>
												</div>
												<div class="p-btn-adc">
													<a onclick="javascript:AjaxAddCart(209,1);" class="btn-append"><b></b>加入购物车</a>
												</div>
											</div>
										</li>
										<li>
											<div class="itemgoodbox">
												<div class="p-img">
													<a target="_blank" href="/Home/Goods/goodsInfo/id/206.html">
														<img src="http://demo5.tp-shop.cn/public/upload/goods/thumb/206/goods_thumb_206_160_160.png">
													</a>
												</div>
												<div class="p-name">
													<a target="_blank" href="/Home/Goods/goodsInfo/id/206.html">TCL 118升 小型双门电冰箱 LED照明 迷你节能 办公居家便捷之选 环保内胆 （芭蕾白）BCD-118KA9</a>
												</div>
												<div class="p-price">
													<strong><em>￥</em><i>769.00</i></strong>
												</div>
												<div class="p-btn-adc">
													<a onclick="javascript:AjaxAddCart(206,1);" class="btn-append"><b></b>加入购物车</a>
												</div>
											</div>
										</li>
										<li>
											<div class="itemgoodbox">
												<div class="p-img">
													<a target="_blank" href="/Home/Goods/goodsInfo/id/204.html">
														<img src="http://demo5.tp-shop.cn/public/upload/goods/thumb/204/goods_thumb_204_160_160.png">
													</a>
												</div>
												<div class="p-name">
													<a target="_blank" href="/Home/Goods/goodsInfo/id/204.html">海尔（Haier)6公斤干衣机 大烘干量 GDZE6-1W</a>
												</div>
												<div class="p-price">
													<strong><em>￥</em><i>1399.00</i></strong>
												</div>
												<div class="p-btn-adc">
													<a onclick="javascript:AjaxAddCart(204,1);" class="btn-append"><b></b>加入购物车</a>
												</div>
											</div>
										</li>
									</ul>
								</div>
								<div class="goods-panel p">
									<ul>
										<li>
											<div class="itemgoodbox">
												<div class="p-img">
													<a target="_blank" href="/Home/Goods/goodsInfo/id/202.html">
														<img src="http://demo5.tp-shop.cn/public/upload/goods/thumb/202/goods_thumb_202_160_160.png">
													</a>
												</div>
												<div class="p-name">
													<a target="_blank" href="/Home/Goods/goodsInfo/id/202.html">西门子 (SIEMENS) 8公斤 变频 滚筒洗衣机 缓震降噪 筒清洁 加漂洗</a>
												</div>
												<div class="p-price">
													<strong><em>￥</em><i>3699.00</i></strong>
												</div>
												<div class="p-btn-adc">
													<a onclick="javascript:AjaxAddCart(202,1);" class="btn-append"><b></b>加入购物车</a>
												</div>
											</div>
										</li>
										<li>
											<div class="itemgoodbox">
												<div class="p-img">
													<a target="_blank" href="/Home/Goods/goodsInfo/id/201.html">
														<img src="http://demo5.tp-shop.cn/public/upload/goods/thumb/201/goods_thumb_201_160_160.png">
													</a>
												</div>
												<div class="p-name">
													<a target="_blank" href="/Home/Goods/goodsInfo/id/201.html">海信（Hisense）LED55E7C 55英寸 超高清4K 曲面电视 HDR 丰富影视教育资源</a>
												</div>
												<div class="p-price">
													<strong><em>￥</em><i>3499.00</i></strong>
												</div>
												<div class="p-btn-adc">
													<a onclick="javascript:AjaxAddCart(201,1);" class="btn-append"><b></b>加入购物车</a>
												</div>
											</div>
										</li>
										<li>
											<div class="itemgoodbox">
												<div class="p-img">
													<a target="_blank" href="/Home/Goods/goodsInfo/id/194.html">
														<img src="http://demo5.tp-shop.cn/public/upload/goods/thumb/194/goods_thumb_194_160_160.png">
													</a>
												</div>
												<div class="p-name">
													<a target="_blank" href="/Home/Goods/goodsInfo/id/194.html">尚品宅配橱柜定制 欧式风格整体橱柜智能厨柜定制多功能橱柜厨房定做 石英石台面厨柜</a>
												</div>
												<div class="p-price">
													<strong><em>￥</em><i>2000.00</i></strong>
												</div>
												<div class="p-btn-adc">
													<a onclick="javascript:AjaxAddCart(194,1);" class="btn-append"><b></b>加入购物车</a>
												</div>
											</div>
										</li>
										<li>
											<div class="itemgoodbox">
												<div class="p-img">
													<a target="_blank" href="/Home/Goods/goodsInfo/id/192.html">
														<img src="http://demo5.tp-shop.cn/public/upload/goods/thumb/192/goods_thumb_192_160_160.png">
													</a>
												</div>
												<div class="p-name">
													<a target="_blank" href="/Home/Goods/goodsInfo/id/192.html">桑扶兰 薄款高侧比大罩杯聚拢性感文胸双胶骨收副乳胸罩内衣WAJ1517S肤色B80</a>
												</div>
												<div class="p-price">
													<strong><em>￥</em><i>159.00</i></strong>
												</div>
												<div class="p-btn-adc">
													<a onclick="javascript:AjaxAddCart(192,1);" class="btn-append"><b></b>加入购物车</a>
												</div>
											</div>
										</li>
									</ul>
								</div>
								<div class="goods-panel p">
									<ul>
										<li>
											<div class="itemgoodbox">
												<div class="p-img">
													<a target="_blank" href="/Home/Goods/goodsInfo/id/190.html">
														<img src="http://demo5.tp-shop.cn/public/upload/goods/thumb/190/goods_thumb_190_160_160.png">
													</a>
												</div>
												<div class="p-name">
													<a target="_blank" href="/Home/Goods/goodsInfo/id/190.html">三枪秋衣秋裤男女情侣纯棉加厚圆领宽松保暖内衣保暖裤男士女士套装</a>
												</div>
												<div class="p-price">
													<strong><em>￥</em><i>99.00</i></strong>
												</div>
												<div class="p-btn-adc">
													<a onclick="javascript:AjaxAddCart(190,1);" class="btn-append"><b></b>加入购物车</a>
												</div>
											</div>
										</li>
										<li>
											<div class="itemgoodbox">
												<div class="p-img">
													<a target="_blank" href="/Home/Goods/goodsInfo/id/189.html">
														<img src="http://demo5.tp-shop.cn/public/upload/goods/thumb/189/goods_thumb_189_160_160.jpeg">
													</a>
												</div>
												<div class="p-name">
													<a target="_blank" href="/Home/Goods/goodsInfo/id/189.html">菲斯奈特黑牌起泡酒 西班牙CAVA产区FREIXENET原味起泡酒促销包邮 西班牙进口 优质起泡酒 纯天然口感 百搭产品！</a>
												</div>
												<div class="p-price">
													<strong><em>￥</em><i>129.00</i></strong>
												</div>
												<div class="p-btn-adc">
													<a onclick="javascript:AjaxAddCart(189,1);" class="btn-append"><b></b>加入购物车</a>
												</div>
											</div>
										</li>
										<li>
											<div class="itemgoodbox">
												<div class="p-img">
													<a target="_blank" href="/Home/Goods/goodsInfo/id/188.html">
														<img src="http://demo5.tp-shop.cn/public/upload/goods/thumb/188/goods_thumb_188_160_160.png">
													</a>
												</div>
												<div class="p-name">
													<a target="_blank" href="/Home/Goods/goodsInfo/id/188.html">欧迪鸟品牌比基尼三件套2018春季新品小胸钢托聚拢遮肚修身温泉泳装女</a>
												</div>
												<div class="p-price">
													<strong><em>￥</em><i>1759.00</i></strong>
												</div>
												<div class="p-btn-adc">
													<a onclick="javascript:AjaxAddCart(188,1);" class="btn-append"><b></b>加入购物车</a>
												</div>
											</div>
										</li>
										<li>
											<div class="itemgoodbox">
												<div class="p-img">
													<a target="_blank" href="/Home/Goods/goodsInfo/id/187.html">
														<img src="http://demo5.tp-shop.cn/public/upload/goods/thumb/187/goods_thumb_187_160_160.png">
													</a>
												</div>
												<div class="p-name">
													<a target="_blank" href="/Home/Goods/goodsInfo/id/187.html">3对硅胶游泳防水透气乳头贴防凸点胸贴防走光乳贴女薄隐形乳晕贴 三代圆形1对+梅花2对【3对装】</a>
												</div>
												<div class="p-price">
													<strong><em>￥</em><i>14.90</i></strong>
												</div>
												<div class="p-btn-adc">
													<a onclick="javascript:AjaxAddCart(187,1);" class="btn-append"><b></b>加入购物车</a>
												</div>
											</div>
										</li>
									</ul>
								</div>
								<div class="c-page-acar">
									<a href="javascript:void(0)" class="c-prev">&lt;</a>
									<a href="javascript:void(0)" class="c-next">&gt;</a>
								</div>
							</div>
						</div>
						<div class="switchable-panel" id="collect-products" style="display: none">
							<div class="goods-list-tab"></div>
							<div class="s-panel-main">
								<p class="wefoc">
									<a href="/home/User/login.html">登录</a>后将显示您之前关注的商品</p>
							</div>
						</div>
						<div class="switchable-panel" id="history-products" style="display: none">
							<div class="goods-list-tab"></div>
							<div class="s-panel-main">
								<p class="wefoc">
									<a href="/home/User/login.html">登录</a>后将显示您之前浏览的商品</p>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="ui-dialog">
			<div class="ui-dialog-title" style="width: 380px;">
				<span>删除</span>
			</div>
			<div class="ui-dialog-content" style="height: 128px; width: 380px; overflow: hidden;">
				<div class="tip-box icon-box">
					<span class="warn-icon m-icon"></span>
					<div class="item-fore">
						<h3 class="ftx-04">删除商品？</h3>
						<div class="ftx-03">您可以选择添加到收藏，或删除商品。</div>
					</div>
					<div class="op-btns ac">
						<a href="javascript:void(0);" id="removeGoods" class="btn-9 select-remove">删除</a>
						<a href="javascript:void(0);" id="addCollect" class="btn-1 ml10 re-select-follow moveCollect">添加我的收藏</a>
					</div>
				</div>
			</div>
			<a class="ui-dialog-close" title="关闭">
				<span class="ui-icon ui-icon-delete"></span>
			</a>
		</div>
		<div class="ui-mask"></div>
		<div class="tpshop-service">
			<ul class="w1224 clearfix">
				<li>
					<i class="ico ico-day7">16</i>
					<p class="service">16天无理由退货</p>
				</li>
				<li>
					<i class="ico ico-day15">15</i>
					<p class="service">15天免费换货</p>
				</li>
				<li>
					<i class="ico ico-quality"></i>
					<p class="service">正品行货 品质保障</p>
				</li>
				<li>
					<i class="ico ico-service"></i>
					<p class="service">专业售后服务</p>
				</li>
			</ul>
		</div>
		<div class="footer">
			<div class="w1224 clearfix" style="padding-bottom: 10px;">
				<div class="left-help-list">
					<div class="help-list-wrap clearfix">
						<dl>
							<dt>新手上路</dt>
						</dl>
						<dl>
							<dt>购物指南</dt>
						</dl>
						<dl>
							<dt>售后服务</dt>
						</dl>
						<dl>
							<dt>支付方式</dt>
						</dl>
						<dl>
							<dt>配送方式</dt>
						</dl>
					</div>
					<div class="friendship-links clearfix">
						<span>友情链接 : </span>
						<div class="links-wrap-h clearfix">
							<a href="https://www.taobao.com">淘宝网</a>
							<a href="https://www.jd.com">京东</a>
							<a href="https://www.vip.com">唯品会</a>
							<a href="https://www.suning.com" target="_blank">苏宁易购</a>
							<a href="https://www.baidu.com">百度</a>
							<a href="http://www.yhd.com">1号店</a>
						</div>
					</div>
				</div>
				<div class="right-contact-us">
					<h3 class="title">联系我们</h3>
					<span class="phone">0744-3649367</span>
					<p class="tips">周一至周日8:00-18:00<br>(仅收市话费)</p>
				</div>
			</div>
			<div class="mod_copyright p">
				<div class="grid-top">
					<a href="/index.php/Home/Article/detail/article_id/34" target="_blank">分销</a><span>|</span>
					<a href="/index.php/Home/Article/detail/article_id/1" target="_blank">新用户注册</a><span>|</span>
				</div>
				<p>Copyright © 2016-2025 TPshop开源商城 版权所有 保留一切权利 备案号:粤ICP备16097249号</p>
				<p class="mod_copyright_auth">
					<a class="mod_copyright_auth_ico mod_copyright_auth_ico_1" href="" target="_blank">经营性网站备案中心</a>
					<a class="mod_copyright_auth_ico mod_copyright_auth_ico_2" href="" target="_blank">可信网站信用评估</a>
					<a class="mod_copyright_auth_ico mod_copyright_auth_ico_3" href="" target="_blank">网络警察提醒你</a>
					<a class="mod_copyright_auth_ico mod_copyright_auth_ico_4" href="" target="_blank">诚信网站</a>
					<a class="mod_copyright_auth_ico mod_copyright_auth_ico_5" href="" target="_blank">中国互联网举报中心</a>
				</p>
			</div>
		</div>
		<style>
			.mod_copyright {
				border-top: 1px solid #EEEEEE;
			}
			
			.grid-top {
				margin-top: 20px;
				text-align: center;
			}
			
			.grid-top span {
				margin: 0 10px;
				color: #ccc;
			}
			
			.mod_copyright>p {
				margin-top: 10px;
				color: #666;
				text-align: center;
			}
			
			.mod_copyright_auth_ico {
				overflow: hidden;
				display: inline-block;
				margin: 0 3px;
				width: 103px;
				height: 32px;
				background-image: url(/template/pc/rainbow/static/images/ico_footer.png);
				line-height: 1000px;
			}
			
			.mod_copyright_auth_ico_1 {
				background-position: 0 -151px;
			}
			
			.mod_copyright_auth_ico_2 {
				background-position: -104px -151px;
			}
			
			.mod_copyright_auth_ico_3 {
				background-position: 0 -184px;
			}
			
			.mod_copyright_auth_ico_4 {
				background-position: -104px -184px;
			}
			
			.mod_copyright_auth_ico_5 {
				background-position: 0 -217px;
			}
		</style>

	</body>

</html>