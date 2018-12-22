<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>登录-开源商城 | B2C商城 | B2B2C商城 | 三级分销 | 免费商城 | 多用户商城 | tpshop｜thinkphp shop｜TPshop 免费开源系统 | 微商城</title>
		<link rel="stylesheet" type="text/css" href="css/tpshop.css">
		<link rel="stylesheet" type="text/css" href="css/base.css">
		<link rel="stylesheet" type="text/css" href="css/myaccount.css">
	</head>

	<body>
		<div class="loginsum_cm">
			<div class="w1224 p">
				<div class="login-dl">
					<a href="/index.php" title="首页">
						<img src="http://demo5.tp-shop.cn/public/upload/logo/2018/04-09/814d7e9a0eddcf3754f2e8373a50a19c.png">
					</a>
				</div>
				<div class="login-welcome">
					<span>欢迎登录</span>
				</div>
			</div>
		</div>
		<div class="loginsum_main" style="background: #bf1919;">
			<div class="w1224 p">
				<div class="advertisement">
					<a href="http://b2t.tp-shop.cn/index.php/Home/Goods/goodsInfo/id/17.html">
						<img src="http://demo5.tp-shop.cn/public/upload/ad/2018/05-16/3601af68d1c641bf0dc45e77b404d09c.jpg" title="" style="">
					</a>
				</div>
				<div class="login_form">
					<div class="lo_intext">
						<div class="layel1">
							<span>账户登录</span>
						</div>
						<form id="loginform" method="post">
							<div class="layel2">
								<div class="text_uspa">
									<label class="judgp uspa_user"></label>
									<input type="text" autofocus="autofocus" class="text_cmu" value="" placeholder="手机号/邮箱" name="username" id="username" autocomplete="off">
								</div>
								<div class="text_uspa">
									<label class="judgp uspa_pwd"></label>
									<input type="password" class="text_cmu" value="" placeholder="密码" name="password" id="password" autocomplete="off">
								</div>
								<div class="text_uspa check_cum">
									<input type="text" class="text_cmu" value="" placeholder="验证码" name="verify_code" id="verify_code" autocomplete="off">
								</div>
								<div class="check_cum_img">
									<img src="/index.php?m=Home&amp;c=User&amp;a=verify" id="verify_code_img" onclick="verify()">
								</div>
								<div class="sum_reme_for p">
									<div class="autplog">
										<label>
<input type="hidden" name="referurl" id="referurl" value="/Home/User/index.html">
<input type="checkbox" class="u-ckb J-auto-rmb" name="autologin" value="1">自动登录
</label>
									</div>
									<div class="foget_pwt">
										<a href="/Home/User/forget_pwd.html">忘记密码？</a>
									</div>
								</div>
								<div class="login_bnt">
									<a href="javascript:void(0);" onclick="checkSubmit();" class="J-login-submit" name="sbtbutton">登&nbsp;&nbsp;&nbsp;&nbsp;录</a>
								</div>
							</div>
						</form>
						<div class="layel3">
							<div class="contactsty">
								<div class="tecant_c">
									<ul>
										<li>
											<a class="justclix" href="/home/LoginApi/login/oauth/alipay.html" title="支付宝">
												<i class="judgp co_alipay"></i>
												<span>支付宝</span>
											</a>
										</li>
										<li class="spacer"></li>
										<li>
											<a class="justclix" href="/home/LoginApi/login/oauth/qq.html" title="QQ">
												<i class="judgp co_qq"></i>
												<span>QQ</span>
											</a>
										</li>
										<li class="spacer"></li>
										<li>
											<a class="justclix" href="/home/LoginApi/login/oauth/weixin.html" title="weixin">
												<i class="judgp co_wechat"></i>
												<span>微信</span>
											</a>
										</li>
									</ul>
								</div>
								<div class="register_c">
									<a class="justclix" href="/Home/User/reg.html">
										<i class="judgp co_register"></i>
										<span>立即注册</span>
									</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
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