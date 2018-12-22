<!DOCTYPE html>
<html lang="en">

	<head>
		<meta charset="UTF-8">
		<title>注册-开源商城 | B2C商城 | B2B2C商城 | 三级分销 | 免费商城 | 多用户商城 | tpshop｜thinkphp shop｜TPshop 免费开源系统 | 微商城</title>
		<meta name="keywords" content="开源商城 B2C商城  B2B2C商城  三级分销  多用户商城  免费商城  微商城">
		<meta name="description" content="TPshop 开源商城 tpshop thinkphp shop B2C商城 B2B2C商城 三级分销 免费商城  微商城 多用户商城 免费开源系统">
		<link href="css/reg3.css" rel="stylesheet">
		<link rel="stylesheet" type="text/css" href="css/base.css">
		<link rel="stylesheet" type="text/css" href="css/tpshop.css">

	</head>

	<body style="">
		<div class="regcon">
			<a class="m-fnlogoa fn-fl" href="/"><img src="http://demo5.tp-shop.cn/public/upload/logo/2018/04-09/814d7e9a0eddcf3754f2e8373a50a19c.png" style="width: 159px;height: 58px;"></a>
			<span class="m-fntit">欢迎注册</span>
			<div class="ui_tab">
				<ul class="ui_tab_nav regnav">
					<li class="uli active ">
						<a href="/Home/User/reg.html">手机注册</a>
					</li>
					<li class="uli  ">
						<a href="/Home/User/reg/t/email.html">邮箱注册</a>
					</li>
					<li class="no fn-fr loginbtn">我已注册，马上
						<a href="/Home/User/login.html">登录&gt;</a>
					</li>
				</ul>
				<form id="reg_form2" method="post" action="">
					<input type="hidden" name="auth_code" value="TPSHOP">
					<input type="hidden" name="scene" value="1">
					<div class="ui_tab_content">
						<div class="m-fnbox ui_panel" style="display: block;">
							<div class="fnlogin clearfix">
								<div class="line">
									<label class="linel"><em>*</em><span class="dt">手机号码：</span></label>
									<div class="liner">
										<input type="text" class="inp fmobile J_cellphone" placeholder="请输入手机号码" name="username" onkeyup="this.value=this.value.replace(/[^\d]/g,'')" id="username" required="">
									</div>
								</div>
								<div class="line">
									<label class="linel"><em>*</em><span class="dt">图像验证码：</span></label>
									<div class="liner">
										<input type="text" class="inp imgcode J_imgcode" placeholder="图像验证码" name="verify_code" required="">
										<img width="100" height="35" src="/index.php/Home/User/verify/type/user_reg.html" id="reflsh_code2" class="po-ab to0">
										<a><img onclick="verify('reflsh_code2')" src="/template/pc/rainbow/static/images/chg_image.png" class="ma-le-210"></a>
									</div>
									<div id="show-voice" class="show-voice"></div>
								</div>
								<div class="line">
									<label class="linel"><em>*</em><span class="dt">手机验证码：</span></label>
									<div class="liner">
										<input type="text" class="inp imgcode J_imgcode" placeholder="手机验证码" id="code" name="code" required="">
										<button class="fn-fl icode" onclick="send_sms_reg_code()" type="button" id="count_down">发送</button>
									</div>
									<div id="show-voice" class="show-voice"></div>
								</div>
								<div class="line">
									<label class="linel"><em>*</em><span class="dt">设置密码：</span></label>
									<div class="liner">
										<input type="password" class="inp fpass J_password" placeholder="6-16位大小写英文字母、数字或符号的组合" autocomplete="off" maxlength="16" id="password" value="" required="">
										<input name="password" type="hidden" value="">
									</div>
								</div>
								<div class="line">
									<label class="linel"><em>*</em><span class="dt">确认密码：</span></label>
									<div class="liner">
										<input type="password" class="inp fsecpass J_password2" placeholder="请再次输入密码" autocomplete="off" maxlength="16" id="password2" required="" value="">
										<input name="password2" type="hidden" value="">
									</div>
								</div>
								<div class="line">
									<label class="linel"><span class="dt">推荐人手机：</span></label>
									<div class="liner">
										<input type="text" class="inp fmobile J_cellphone" placeholder="请输入手机号码" onkeyup="this.value=this.value.replace(/[^\d]/g,'')" name="invite">
									</div>
								</div>
								<div class="line liney clearfix">
									<label class="linel">&nbsp;</label>
									<div class="liner">
										<div class="clearfix checkcon">
											<p class="fn-fl checktxt"><input type="checkbox" id="checktxt" class="iyes fn-fl J_protocal" checked="">
												<span class="fn-fl">我已阅读并同意</span>
												<a class="itxt fn-fl" href="/Home/Article/agreement/doc_code/agreement.html" target="_blank">《服务协议》</a>
											</p>
											<p class="fn-fl errorbox v-txt" id="protocalBox"></p>
										</div>
										<a class="regbtn J_btn_agree" href="javascript:void(0);" onclick="check_submit();">同意协议并注册</a>
										<p class="v-txt" id="err_check_code">
											<span class="fnred">请勾选</span>我已阅读并同意
											<a class="itxt" href="/Home/Article/agreement/doc_code/agreement.html" target="_blank">《服务协议》</a>
										</p>
									</div>
								</div>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>

		<div class="footer p">
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
		</div>

	</body>

</html>