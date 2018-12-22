<!DOCTYPE html>
<html lang="en">

	<head>
		<meta charset="UTF-8">
		<title>订单支付-TPshop开源商城</title>
		<meta name="keywords" content="速度 开源  安全 高效">
		<meta name="description" content="国内著名的开源商城系统">

		<link rel="stylesheet" type="text/css" href="css/tpshop.css">
		<link rel="stylesheet" href="css/jh.css">

	</head>

	<body>
		<div class="top-hander p">
			<div class="w1224 pr">
				<div class="fl">

					<div class="ls-dlzc fl islogin">
						<a class="red userinfo" href="/index.php/Home/user/index.html">13800138006</a>
						<a href="/index.php/Home/user/logout.html">退出</a>
					</div>
					<div class="fl spc" style="margin-top:10px"></div>
					<div class="sendaddress pr fl">
					</div>
				</div>
				<div class="top-ri-header fr">
					<ul>
						<li>
							<a target="_blank" href="/index.php/Home/Order/order_list.html">我的订单</a>
						</li>
						<li class="spacer"></li>
						<li>
							<a target="_blank" href="/index.php/Home/User/account.html">我的积分</a>
						</li>
						<li class="spacer"></li>
						<li>
							<a target="_blank" href="/index.php/Home/User/coupon.html">我的优惠券</a>
						</li>
						<li class="spacer"></li>
						<li>
							<a target="_blank" href="/index.php/Home/User/goods_collect.html">我的收藏</a>
						</li>
						<li class="spacer"></li>
						<li class="hover-ba-navdh">
							<div class="nav-dh">
								<span>客户服务</span>
								<i class="jt-x"></i>
								<div class="conta-hv-nav">
									<ul>
										<li>
											<a href="/index.php/Seller/Index/index.html">商家后台</a>
										</li>
										<li>
											<a href="/index.php/Home/Newjoin/index.html">商家帮助</a>
										</li>
									</ul>
								</div>
							</div>
						</li>
						<li class="spacer"></li>
						<li class="navoxth">
							<div class="nav-dh">
								<i class="fl ico"></i>
								<span>手机搜豹商城</span>
								<i class="jt-x"></i>
							</div>
							<div class="sub-panel m-lst">
								<p>扫一扫，下载搜豹商城客户端</p>
								<dl>
									<dt class="fl mr10"><a target="_blank" href=""><img height="80" width="80" src="/index.php?m=Home&amp;c=Index&amp;a=qr_code&amp;data=http://demo6.tp-shop.cn/index.php/Mobile/index/app_down.html&amp;head_pic=http://demo6.tp-shop.cn/http://demo5.tp-shop.cn/public/static/images/logo/pc_home_logo_default.png&amp;back_img="></a></dt>
									<dd class="fl mb10">
										<a target="_blank" href=""><i class="andr"></i> Andiord</a>
									</dd>
									<dd class="fl">
										<a target="_blank" href=""><i class="iph"></i> iPhone</a>
									</dd>
								</dl>
							</div>
						</li>
						<li class="spacer"></li>
					</ul>
				</div>
			</div>
		</div>
		<script type="text/javascript">
			//用户登录或为登录状态显示
			function user_login_or_no() {
				var uname = getCookie('uname');
				var head_pic = getCookie('head_pic');
				if(uname == '') {
					$('.islogin').remove();
					$('.nologin').show();
				} else {
					$('.nologin').remove();
					$('.islogin').show();
					$('.userinfo').html(decodeURIComponent(uname));
				}
			}

			$(document).ready(function() {
				user_login_or_no();
			});
		</script>
		<div class="fn-cart-pay">
			<div class="wrapper1190">
				<div class="order-header">
					<div class="layout after">
						<div class="fl">
							<div class="logo pa-to-36 wi345">
								<a href="/"><img src="http://demo5.tp-shop.cn/public/static/images/logo/pc_home_logo_default.png" alt="" style="max-width: 240px;max-height: 80px;"></a>
							</div>
						</div>
						<div class="fr">
							<div class="pa-to-36 progress-area">
								<div class="progress-area-wd" style="display:none">我的购物车</div>
								<div class="progress-area-tx" style="display:none">填写核对订单信息</div>
								<div class="progress-area-cg">成功提交订单</div>
							</div>
						</div>
					</div>
				</div>
				<div class="layout after-ta order-ha">
					<div class="erhuh">
						<i class="icon-succ"></i>
						<h3>订单提交成功，请您尽快付款！</h3>
						<p class="succ-p">
							订单号：&nbsp;&nbsp;201807061436588156&nbsp;&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;&nbsp; 付款金额（元）：&nbsp;&nbsp;
							<b>1</b>&nbsp;<b>元</b>
						</p>
						<div class="succ-tip">
							请您在&nbsp;&nbsp;<b>1530945418</b>&nbsp;完成支付，否则订单将自动取消
						</div>
					</div>
					<div class="ddxq-xiaq">
						<a href="/index.php/Home/Order/order_list.html">订单详情<i></i></a>
					</div>
					<form action="/index.php/Home/Payment/getCode.html" method="post" name="cart4_form" id="cart4_form">
						<div class="orde-sjyy">
							<h3 class="titls">选择支付方式</h3>
							<div class="bsjy-g">
								<dl>
									<dd>
										<div class="order-payment-area">
											<div class="dsfzfpte">
												<b>选择支付方式</b>
											</div>
											<div class="po-re dsfzf-ee">
												<ul>
													<li>
														<div class="payment-area">
															<input type="radio" id="input-ALIPAY-1" value="pay_code=unionpay" class="radio vam" name="pay_radio">
															<label for="">
<img src="/plugins/payment/unionpayhttp://demo5.tp-shop.cn/public/upload/logistics/unionpay.jpg" width="120" height="40" onclick="change_pay(this);">
</label>
														</div>
													</li>
													<li>
														<div class="payment-area">
															<input type="radio" id="input-ALIPAY-1" value="pay_code=tenpay" class="radio vam" name="pay_radio">
															<label for="">
<img src="/plugins/payment/tenpayhttp://demo5.tp-shop.cn/public/upload/logistics/tenpay.jpg" width="120" height="40" onclick="change_pay(this);">
</label>
														</div>
													</li>
													<li>
														<div class="payment-area">
															<input type="radio" id="input-ALIPAY-1" value="pay_code=alipay" class="radio vam" name="pay_radio">
															<label for="">
<img src="/plugins/payment/alipay/logo.jpg" width="120" height="40" onclick="change_pay(this);">
</label>
														</div>
													</li>
													<li>
														<div class="payment-area">
															<input type="radio" id="input-ALIPAY-1" value="pay_code=weixin" class="radio vam" name="pay_radio">
															<label for="">
<img src="/plugins/payment/weixin/logo.jpg" width="120" height="40" onclick="change_pay(this);">
</label>
														</div>
													</li>
												</ul>
											</div>
										</div>
									</dd>
								</dl>
								<div class="order-payment-action-area">
									<a class="button-style-5 button-confirm-payment" href="javascript:void(0);" onclick="$('#cart4_form').submit();">确认支付方式</a>
								</div>
							</div>
						</div>
						<input type="hidden" name="master_order_sn" value="201807061436588156">
						<input type="hidden" name="order_id" value="973">
					</form>
				</div>
			</div>
		</div>
		<div id="wchatQrcodeDlg" class="g-cartpay-dlg" style="display: none;" data-show="">
			<div class="g-cartpay-content">
				<div class="g-h"><span class="u-close"></span></div>
				<div class="g-c">
					<div class="g-t"> 使用微信支付<span>￥<small class="wx_amount">118</small></span></div>
					<div class="g-qrcode"><img alt="使用微信支付" src="images/loading.gif"></div>
				</div>
				<div class="g-f fixed"><i class="icon_scan"></i>
					<div class="u-label">
						<p>请使用微信扫一扫<br> 扫描二维码完成支付
						</p>
					</div>
				</div>
			</div>
			<div class="u-mask"></div>
		</div>
		<div id="addCardNewBind"></div>
		<div class="footer p">
			<div class="mod_service_inner">
				<div class="w1224">
					<ul>
						<li>
							<div class="mod_service_unit">
								<h5 class="mod_service_duo">多</h5>
								<p>品类齐全，轻松购物</p>
							</div>
						</li>
						<li>
							<div class="mod_service_unit">
								<h5 class="mod_service_kuai">快</h5>
								<p>多仓直发，极速配送</p>
							</div>
						</li>
						<li>
							<div class="mod_service_unit">
								<h5 class="mod_service_hao">好</h5>
								<p>正品行货，精致服务</p>
							</div>
						</li>
						<li>
							<div class="mod_service_unit">
								<h5 class="mod_service_sheng">省</h5>
								<p>天天低价，畅选无忧</p>
							</div>
						</li>
					</ul>
				</div>
			</div>
			<div class="w1224">
				<div class="footer-ewmcode">
					<div class="foot-list-fl">
						<div class="foot-list-wrap p">
							<ul>
								<li class="foot-th">
									系统分类 </li>
							</ul>
							<ul>
								<li class="foot-th">
									购物常见问题 </li>
								<li>
									<a href="/index.php/Home/Article/detail/article_id/4.html">购物流程</a>
								</li>
							</ul>
							<ul>
								<li class="foot-th">
									支付方式 </li>
								<li>
									<a href="/index.php/Home/Article/detail/article_id/5.html">商城支持的支付方式</a>
								</li>
							</ul>
							<ul>
								<li class="foot-th">
									购物指南 </li>
								<li>
									<a href="/index.php/Home/Article/detail/article_id/9.html">购物指南</a>
								</li>
							</ul>
							<ul>
								<li class="foot-th">
									退款/售后 </li>
								<li>
									<a href="/index.php/Home/Article/detail/article_id/3.html">退款售后流程</a>
								</li>
							</ul>
						</div>
						<div class="friendship-links p">
							<span>友情链接 : </span>
							<div class="links-wrap-h p">
								<a href="https://www.taobao.com/">淘宝网</a>
								<a href="https://www.jd.com">京东</a>
								<a href="http://www.meituan.com/">美团</a>
								<a href="http://www.feiniu.com/">飞牛网</a>
								<a href="https://www.vip.com/">唯品会</a>
							</div>
						</div>
					</div>
					<div class="right-contact-us">
						<h3 class="title">客服热线（9:00-22:00）</h3>
						<span class="phone">15889560670</span>
						<p class="tips">官方微信</p>
						<div class="qr-code-list clearfix">
							<a class="qr-code qr-code-tpshop" href="javascript:;">
								<img src="http://demo5.tp-shop.cn/public/static/images/qrcode.png" alt="">
							</a>
						</div>
					</div>
				</div>
				<div class="mod_copyright p">
					<div class="grid-top">
						<a href="/index.php/Home/Article/detail/article_id/11" target="_blank">信息公告</a><span>|</span>
						<a href="/index.php/Home/Article/detail/article_id/1" target="_blank">商家入驻流程</a><span>|</span>
					</div>
					<p>Copyright © 2016-2025 搜豹商城 版权所有 保留一切权利 备案号:粤icp 923897898111</p>
					<p class="mod_copyright_auth">
						<a class="mod_copyright_auth_ico mod_copyright_auth_ico_1" href="" target="_blank">经营性网站备案中心</a>
						<a class="mod_copyright_auth_ico mod_copyright_auth_ico_2" href="" target="_blank">可信网站信用评估</a>
						<a class="mod_copyright_auth_ico mod_copyright_auth_ico_3" href="" target="_blank">网络警察提醒你</a>
						<a class="mod_copyright_auth_ico mod_copyright_auth_ico_4" href="" target="_blank">诚信网站</a>
						<a class="mod_copyright_auth_ico mod_copyright_auth_ico_5" href="" target="_blank">中国互联网举报中心</a>
					</p>
				</div>
			</div>
		</div>

	</body>

</html>