<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title>购物车结算-TPshop开源商城</title>
		<link rel="stylesheet" type="text/css" href="css/tpshop.css">
		<link rel="stylesheet" type="text/css" href="css/myaccount.css">

	</head>

	<body>
		<div class="topic-banner" style="background: #f37c1e;">
			<div class="w1224">
				<a href="">
					<img src="http://demo5.tp-shop.cn/public/upload/ad/2018/03-05/a8f79171ba070fb1bd02b465ad6fe7c3.jpg">
				</a>
				<i onclick="$('.topic-banner').hide();"></i>
			</div>
		</div>
		<div class="sett_hander p">
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
			<div class="nav-middan-z p">
				<div class="header w1224">
					<div class="ecsc-logo fon_gwcshcar">
						<a href="/" class="logo"> <img src="http://demo5.tp-shop.cn/public/static/images/logo/pc_home_logo_default.png"></a>
						<span>购物车</span>
					</div>
					<div class="liucsell">
						<div class="line-flowpath">
							<span class="green"><i class="las-flo"></i><em>1、我的购物车</em></span>
							<span class="green now"><i class="las-flo2"></i><em>2、填写核对订单信息</em></span>
							<span><i class="las-flo3"></i><em>3、成功提交订单</em></span>
						</div>
					</div>
				</div>
			</div>
		</div>
		<form name="cart2_form" id="cart2_form" method="post" autocomplete="off">
			<input type="hidden" name="is_virtual" value="0">
			<input type="hidden" name="address_id" value="15">
			<input type="hidden" name="pay_points" value="">
			<input type="hidden" name="user_money" value="">
			<input type="hidden" id="order_invoice_title" name="invoice_title" value="">
			<input type="hidden" id="order_taxpayer" name="taxpayer" value="">
			<input type="hidden" name="action" value="">
			<input type="hidden" name="goods_id" value="">
			<input type="hidden" name="item_id" value="">
			<input type="hidden" name="goods_num" value="">
			<input type="hidden" name="pwd" value="">
			<input type="hidden" name="auth_code" value="TPSHOP">
			<input type="hidden" name="mobile" value="">
			<input type="hidden" name="user_note[3]" value="">
		</form>
		<div class="fillorder shipping_div">
			<div class="w1224">
				<p class="tit">填写并核对订单信息</p>
				<div class="spriteform" id="ajax_address"><i class="sprite_le_ri"></i>
					<div class="top_leg p">
						<span class="paragraph fl"><i class="ddd"></i>收货人信息</span>
						<a id="addNewAddress" class="newadd fr" href="javascript:void(0);" onclick="add_edit_address(this);" data-address-id="0">新增收货地址</a>
					</div>
					<div class="consignee-list p">
						<ul>
							<li class="addressItem" data-address-id="15">
								<div class="item_select_t curtr fl">
									<span>夏季&nbsp;河北省</span>
									<b></b>
								</div>
								<div class="addrdetail fl">
									<span class="addr-name" title="夏季">夏季</span>
									<span class="addr-info" title="河北省 邯郸市 复兴区 胜利桥街道 华亿路3322号">
河北省 邯郸市 复兴区 胜利桥街道 华亿路3322号 </span>
									<span class="addr-tel" title="15274851694">15274851694</span>
									<span class="addr-default">默认地址</span>
								</div>
								<div class="opbtns_editdel">
									<a href="javascript:void(0);" onclick="add_edit_address(this);" class="ftx">编辑</a>
									<a href="javascript:void(0);" onclick="del_address(this);" class="ftx">删除</a>
								</div>
							</li>
						</ul>
					</div>
					<script>
						/**
						 * 新增修改收货地址
						 */
						function add_edit_address(obj) {
							var url = '';
							var id = $(obj).parents('.addressItem').attr('data-address-id');
							if(typeof(id) == "undefined") {
								id = 0;
							}
							if(typeof(id) == "undefined") {
								url = "/index.php?m=Home&c=User&a=add_address&scene=1&call_back=call_back_fun"; // 新增地址
							} else {
								url = "/index.php?m=Home&c=User&a=edit_address&scene=1&call_back=call_back_fun&id=" + id;
							}
							layer.open({
								type: 2,
								title: '添加收货地址',
								shadeClose: true,
								shade: 0.8,
								area: ['880px', '580px'],
								content: url
							});
						}
						// 添加修改收货地址回调函数
						function call_back_fun(v) {
							layer.closeAll(); // 关闭窗口
							ajax_address(); // 刷新收货地址
						}
						/**
						 * 删除收货地址
						 * @param obj
						 */
						function del_address(obj) {
							var id = $(obj).parents('.addressItem').attr('data-address-id');
							layer.confirm("确定要删除吗?", {
								btn: ['确定', '取消'] //按钮
							}, function() {
								layer.closeAll();
								$.ajax({
									url: "/index.php?m=Home&c=User&a=del_address&id=" + id,
									success: function(data) {
										window.parent.ajax_address(); // 刷新收货地址
									}
								});
							}, function(index) {
								layer.close(index);
							});
						}
						//设置默认地址
						function set_address_default(obj) {
							var id = $(obj).parents('.addressItem').attr('data-address-id');
							$.ajax({
								url: "/index.php?m=Home&c=User&a=setAddressDefault",
								type: 'post',
								data: {
									id: id
								},
								dataType: 'json',
								success: function(data) {
									if(data.status == 1) {
										window.parent.ajax_address(); // 刷新收货地址
									} else {
										layer.msg(data.msg, {
											icon: 2
										});
									}
								}
							});
						}
					</script>
				</div>
			</div>
		</div>
		<div class="sendgoodslist">
			<div class="w1224">
				<div class="top_leg p ma-to-20">
					<span class="paragraph fl"><i class="ddd"></i>送货清单</span>
					<a class="newadd fr" href="/index.php/Home/Cart/index.html">返回修改购物车</a>
					<a class="newadd fr hover-y">
						<i class="las-warning"></i>价格说明
						<div class="pairgoods">
							<p class="tit">因可能存在系统缓存、页面更新导致价格变动异常等不确定性情况出现，商品售价以本结算页商品价格为准；如有疑问，请您立即联系销售商咨询</p>
						</div>
					</a>
				</div>
				<div class="shopping-listpay">
					<div class="dis-modes-li">
						<div class="modti p shipping_div">
							<h2>配送方式</h2>
							<span class="newadd hover-y">
<i class="las-warning"></i>对应商品
<div class="pairgoods">
<ul>
<li>
<img style="width: 65px;height: 65px;" src="http://demo5.tp-shop.cn/public/upload/goods/thumb/4/goods_thumb_4_65_65.png">
<p class="shop_name"><a href="/index.php/Home/Goods/goodsInfo/id/4.html" target="_blank">七匹狼牛仔裤男2018春季新款青年直筒修身裤子商务休闲男裤3769 101藏青色 32/80A</a></p>
</li>
</ul>
</div>
</span>
						</div>
						<div class="shipment ma-to-20 shipping_div">
							<div class="fore1 p">
								<span class="mode-label">配送时间：</span>
								<div class="mode-infor hover-y">
									<p><label>工作日、双休日与节假日均可送货</label></p>
								</div>
							</div>
						</div>
						<div class="shipment ma-to-20 shipping_div">
							<div class="fore1 p">
								<span class="mode-label">运&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;费：</span>
								<div class="mode-infor hover-y">
									<p class="tp-c-red1" id="store_freight_3">包邮</p>
								</div>
							</div>
						</div>
						<div class="standard_wei buy-remarks no_shipping_div" style="display: none;">
							<span>手机 : </span><input style="width: 230px" id="mobile" maxlength="13" placeholder="请输入手机号码,接受兑换码">
						</div>
						<div class="standard_wei buy-remarks">
							<span>备注 : </span><textarea class="user_note_txt" data-store-id="3" maxlength="50" placeholder="最多输入50个字"></textarea>
						</div>
					</div>
					<div class="goods-list-ri">
						<div class="goodsforma">
							<div class="modti p">
								<h2>卖家：兴宇服饰旗舰店</h2>
							</div>
							<div class="goods-last-suit ma-to-10 p">
								<div class="goods-suit-tit" style="display: none">
									<span class="sales-icon">订单优惠</span>
									<strong id="store_order_prom_title_3"></strong>
								</div>
							</div>
							<ul class="buy-shopping-list">
								<li>
									<div class="goods-extra clearfix">
										<div class="p-img">
											<a target="_blank" href="/index.php/Home/Goods/goodsInfo/id/4.html">
												<img src="http://demo5.tp-shop.cn/public/upload/goods/thumb/4/goods_thumb_4_102_102.png" alt="">
											</a>
											<div class="p-img-tips goods_shipping_img" id="goods_shipping_img_4" style="display: none">暂无商品</div>
										</div>
										<div class="goods-msg clearfix">
											<div class="tp-cart-goods-name">
												<a href="/index.php/Home/Goods/goodsInfo/id/4.html" target="_blank">七匹狼牛仔裤男2018春季新款青年直筒修身裤子商务休闲男裤3769 101藏青色 32/80A</a>
											</div>
											<ul class="tp-cart-goods-mes">
												<li class="tp-c-red1">选择尺码:28/70A</li>
												<li>
													<span>x1</span>
													<span class="tp-bold tp-c-red1">￥ 179.00</span>
												</li>
												<li>
													<span class="goods_shipping_title" id="goods_shipping_title_4">有货</span>
													<span class="tp-c-red1 shipping_div">0g</span>
												</li>
											</ul>
											<div class="msp_return">
												<p class="guarantee-item">
													<i class="return7 return7-dark"></i><span class="f_dark">不支持七天无理由退货</span>
												</p>
											</div>
										</div>
									</div>
								</li>
							</ul>
						</div>
					</div>
					<div class="total-weight shipping_div"><span>总重量 : </span>0g</div>
				</div>
			</div>
		</div>
		<div class="addremark">
			<div class="w1224">
				<div class="top_leg p ma-to-20">
					<span class="paragraph fl"><i class="ddd"></i>发票信息</span>
				</div>
				<div class="invoice-cont ma-to-20" id="changeinfo">
					<span id="span1" style="display: none;">普通发票（纸质）</span>
					<span id="span2" style="display: none;">个人</span>
					<span id="span3" style="display: none;">明细</span>
					<span id="span4" style="">不开发票</span>
					<a onclick="invoice_dialog();" href="javascript:void(0);">修改</a>
				</div>
			</div>
		</div>
		<div class="usecou-step-tit" id="usecou-step-tit">
			<div class="w1224">
				<div class="top_leg p ma-to-20">
					<span class="paragraph usewhilejs fl"><i class="ddd"></i>使用优惠券/抵用</span>
					<p class="coupon-des">(可用优惠券<i class="coupon-num">0</i>张)</p>
				</div>
				<div class="coupon-detail">
					<div class="detail-title clearfix">
						<ul class="available-title">
							<li class="active">
								<a href="javascript:;">可用优惠券 ( <i class="available-num">0</i> )</a>
							</li>
							<li>
								<a href="javascript:;">不可用优惠券 ( <i class="unavailable-num">0</i> )</a>
							</li>
						</ul>
					</div>
					<div class="detail-cont">
						<ul class="available">
							<li style="display: list-item;">
								<div class="coupon-list coupon-able-list p">
								</div>
								<p class="coupon-list-des"><i class="ico-warn"></i>部分优惠券不可叠加使用</p>
							</li>
							<li>
								<div class="coupon-list p">
								</div>
							</li>
						</ul>
					</div>
					<div class="score-list">
						<p class="item">
							<label>
<input id="pay_points_checkbox" type="checkbox">
使用积分余额 :
<input id="pay_points" type="text" disabled="disabled" onpaste="this.value=this.value.replace(/[^\d]/g,'')" onkeyup="this.value = this.value.replace(/[^\d]/g, '')">
点（您当前积分<span>100</span>点）
</label>
						</p>
						<p class="item">
							<label>
<input id="user_money_checkbox" type="checkbox" disabled="disabled">
使用账户余额 :
<input id="user_money" type="text" disabled="disabled" onpaste="this.value=this.value.replace(/[^\d\.]/g,'')" onkeyup="this.value = /^\d+\.?\d{0,2}$/.test(this.value) ? this.value : ''">
元（您当前余额<span>0.00</span>元）
</label>
						</p>
						<p class="item">
							<label>
<input type="checkbox" id="coupon_code_checkbox">
使用优惠券码 :
<input type="text" id="coupon_code" disabled="disabled">
<input type="text" style="width: 0;height:0;filter:'alpha(opacity=0)';opacity:0;">
<button class="exchange" id="coupon_exchange">
兑换
</button>
</label>
						</p>
						<p class="item">
							<label>
支　付　密　码 :
<input type="password" id="pwd">
请先<a target="_blank" href="/index.php/home/User/paypwd.html" style="color: #e23435;">设置支付密码</a>
</label>
						</p>
					</div>
				</div>
			</div>
			<script>
				function hidediv() {
					$("#invoice_title").css({
						"border": ""
					});
					$("#personage").css({
						"border": "2px solid #e4393c"
					});
					$('#adddiv').hide();
					$("#ratepaying").hide();
					if(!$('#adddiv').is(":hidden")) {
						$("#addinvoice").hide();
					} else {
						$("#addinvoice").show();
					}
				}

				function togglediv() {
					$("#personage").css({
						"border": ""
					});
					$("#invoice_title").css({
						"border": "2px solid #e4393c"
					});
					$('#adddiv').toggle();
					$("#ratepaying").toggle();
					if(!$('#adddiv').is(":hidden")) {
						$("#addinvoice").hide();
					} else {
						$("#addinvoice").show();
					}
				}
				// 校验组织机构代码
				function orgcodevalidate(value) {
					if(value != "") {
						var part1 = value.substring(0, 8);
						var part2 = value.substring(value.length - 1, 1);
						var ws = [3, 7, 9, 10, 5, 8, 4, 2];
						var str = '0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ';
						var reg = /^([0-9A-Z]){8}$/;
						if(!reg.test(part1)) {
							return true
						}
						var sum = 0;
						for(var i = 0; i < 8; i++) {
							sum += str.indexOf(part1.charAt(i)) * ws[i];
						}
						var C9 = 11 - (sum % 11);
						var YC9 = part2 + '';
						if(C9 == 11) {
							C9 = '0';
						} else if(C9 == 10) {
							C9 = 'X';
						} else {
							C9 = C9 + '';
						}
						return YC9 != C9;
					}
				}
				// 校验地址码
				function checkAddressCode(addressCode) {
					var provinceAndCitys = {
						11: "北京",
						12: "天津",
						13: "河北",
						14: "山西",
						15: "内蒙古",
						21: "辽宁",
						22: "吉林",
						23: "黑龙江",
						31: "上海",
						32: "江苏",
						33: "浙江",
						34: "安徽",
						35: "福建",
						36: "江西",
						37: "山东",
						41: "河南",
						42: "湖北",
						43: "湖南",
						44: "广东",
						45: "广西",
						46: "海南",
						50: "重庆",
						51: "四川",
						52: "贵州",
						53: "云南",
						54: "西藏",
						61: "陕西",
						62: "甘肃",
						63: "青海",
						64: "宁夏",
						65: "新疆",
						71: "台湾",
						81: "香港",
						82: "澳门",
						91: "国外"
					};
					var check = /^[1-9]\d{5}$/.test(addressCode);
					if(!check) return false;
					if(provinceAndCitys[parseInt(addressCode.substring(0, 2))]) {
						return true;
					} else {
						return false;
					}

				}
				//保存发票
				function save_invoice() {
					var invoice_title = $("#personage").val();
					var invoice_desc = $("#invoice_desc").val();
					var data = {
						invoice_title: "个人",
						invoice_desc: invoice_desc
					};
					if(!$('#ratepaying').is(":hidden") && invoice_desc != "不开发票") {
						invoice_title = $("#invoice_title").val();
						if(invoice_title.length == 0) {
							layer.msg("发票抬头不能为空", {
								icon: 2
							});
							return false;
						}
						var taxpayer = $("#taxpayer").val();
						//                    if (taxpayer.length > 0) {
						if((taxpayer.length == 15) || (taxpayer.length == 18) || (taxpayer.length == 20)) {} else {
							layer.msg("请输入正确的纳税人识别号！", {
								icon: 2
							});
							return;
						}
						var addressCode = taxpayer.substring(0, 6);
						// 校验地址码
						var check = checkAddressCode(addressCode);
						if(!check) {
							layer.msg("请输入正确的纳税人识别号(地址码)！", {
								icon: 2
							});
							return;
						}
						// 校验组织机构代码
						var orgCode = taxpayer.substring(6, 9);
						check = orgcodevalidate(orgCode);
						if(!check) {
							layer.msg("请输入正确的纳税人识别号(组织机构代码) ！", {
								icon: 2
							});
							return;
						}
						$('#order_taxpayer').val(taxpayer);
						//                    }
						$('#order_invoice_title').val(invoice_title);
						var data = {
							invoice_title: invoice_title,
							taxpayer: taxpayer,
							invoice_desc: invoice_desc
						};
					} else {
						$('#order_taxpayer').val("");
						$('#order_invoice_title').val("个人");
						//                    $("#invoice_title").val("个人");
					}
					if(invoice_desc == "不开发票") {
						$('#order_invoice_title').val("");
						$('#order_taxpayer').val("");
						$("#span1,#span2,#span3").hide();
						$("#span4").show();
					} else {
						$('#span2').text($('#order_invoice_title').val());
						$('#span3').text(invoice_desc);
						$("#span4").hide();
						$("#span1,#span2,#span3").show();
					}
					$.post("/index.php/home/Cart/save_invoice.html", data, function(json) {
						var data = eval("(" + json + ")");
					});
					//                 window.location.reload();
					return true;
				}
				/*
				 * 优惠券列表切换
				 *1、优惠券数量: 根据列表里面的列表项的数量自动填充
				 *2、优惠券选中：优惠券默认可以多选，当时同一种商品优惠券只选一种，默认根据其id判断，页面
				 * 暂时用<div class="coupon-item coupon-invalid" data-date="0" data-shopid="1"> 中的
				 * data-shopid="1"来表示id的值
				 * 3、快过期优惠券和正常优惠券样式区别很大，还自带选中效果，如果是同一个一列表循环出来的
				 * 数据需要带一快过期的标志过来页面暂时用<div class="coupon-item coupon-invalid"
				 * data-date="0" data-shopid="1"> 中的 data-date="0" 来表示，值是1代表是快过期的				 *
				 * */
				function couponChange() { //优惠券列表切换
					//优惠券数量
					var $_couponWrap = $('#usecou-step-tit');
					var couponNum1 = $_couponWrap.find('.available li').eq(0).find('.coupon-item').length; //获取能使用的优惠券数量
					var couponNum2 = $_couponWrap.find('.available li').eq(1).find('.coupon-item').length; //获取不能使用的优惠券数量
					$_couponWrap.find('.coupon-num').text(couponNum1);
					$_couponWrap.find('.available-num').text(couponNum1);
					$_couponWrap.find('.unavailable-num').text(couponNum2);
					$_couponWrap.find('.available li').eq(0).find('.coupon-item[data-date="1"]').addClass('coupon-invaliding');
					$_couponWrap.find('.available li').eq(0).unbind('click').on("click", '.coupon-item', function() {
						//点击可用优惠券事件
						$(this).toggleClass('checked');
						if($(this).hasClass('checked')) {
							var id = $(this).attr('data-shopid');
							$(this).siblings().each(function() { //同一个商品只能选一个优惠券
								if($(this).attr('data-shopid') == id) {
									$(this).removeClass('checked')
								}
							})
						}
						$('#cart2_form').find("input[name^='coupon_id']").remove();
						var couponList = $(this).parents('.coupon-list').find('.coupon-item');
						couponList.each(function() {
							if($(this).hasClass('checked')) {
								var store_id = $(this).attr('data-shopid');
								var store_coupon = $("input[name='coupon_id[" + store_id + "]']");
								if(store_coupon > 0) {
									store_coupon.attr('value', $(this).attr('data-coupon-id'));
								} else {
									var input = document.createElement('input'); //创建input节点
									input.setAttribute('type', 'hidden'); //定义类型是文本输入
									input.setAttribute('value', $(this).attr('data-coupon-id'));
									input.setAttribute('name', "coupon_id[" + store_id + "]");
									document.getElementById('cart2_form').appendChild(input); //添加到form中显示
								}
							}
						})
						ajax_order_price();
					});
					//切换优惠券列表
					$_couponWrap.find('.available li').eq(0).show();
					$_couponWrap.find('.available-title li').click(function() {
						$(this).addClass('active').siblings().removeClass('active');
						$_couponWrap.find('.available li').eq($(this).index()).show().siblings().hide();
					})
					//数字输入框智能判断
					$_couponWrap.find('.score-list').find('.txt').blur(function() {
						var val = $(this).val();
						if(isNaN(val)) {
							$(this).val('0');
						} else {
							if(val < 0) {
								$(this).val('0');
							} else {
								val = Math.round(val * 100) / 100;
								$(this).val(val);
							}
						}
					});
				}
				couponChange();
			</script>
		</div>
		<div class="order-summary p">
			<div class="w1224">
				<div class="statistic fr">
					<div class="list">
						<span><em class="ftx-01">1</em> 件商品，总商品金额：</span>
						<em class="price">￥179</em>
					</div>
					<div class="list">
						<span>优惠券：</span>
						<em class="price" id="couponFee">-￥0</em>
					</div>
					<div class="list">
						<span>优惠：</span>
						<em class="price" id="order_prom_amount">-￥0</em>
					</div>
					<div class="list">
						<span>运费：</span>
						<em class="price" id="postFee">￥0</em>
					</div>
					<div class="list">
						<span>余额支付：</span>
						<em class="price" id="balance">-￥0</em>
					</div>
					<div class="list">
						<span>积分支付：</span>
						<em class="price" id="pointsFee">-￥0</em>
					</div>
				</div>
			</div>
		</div>
		<div class="trade-foot p">
			<div class="w1224">
				<div class="trade-foot-detail-com">
					<div class="fc-price-info">
						<span class="price-tit">应付总额：</span>
						<span class="price-num" id="payables">￥179</span>
					</div>
					<div class="fc-consignee-info shipping_div">
						<span class="mr20">寄送至： <span id="address_info">河北省 邯郸市 复兴区 胜利桥街道 华亿路3322号</span></span>
						<span id="sendMobile">收货人：<span id="address_user">夏季 15274851694</span></span>
					</div>
				</div>
			</div>
		</div>
		<div class="submitorder_carpay p">
			<div class="w1224">
				<button type="submit" class="checkout-submit" onclick="submit_order();">
提交订单
</button>
			</div>
		</div>
		<div class="ui-dialog infom-dia">
			<div class="ui-dialog-title">
				<span>发票信息</span>
				<a class="ui-dialog-close" title="关闭">
					<span class="ui-icon ui-icon-delete"></span>
				</a>
			</div>
			<div class="ui-dialog-content" style="height: 600px">
				<div class="invoice-dialog">
					<div class="tab-nav p">
						<ul>
							<li>
								<div class="item_select_t curtr">
									<span>普通发票</span>
									<b></b>
								</div>
							</li>
						</ul>
					</div>
					<div class="zinvoice-tips">
						<i>1</i>
						<span class="tip-cont">开票金额不包优惠券和积分支付部分。</span>
						<i>2</i>
						<span class="tip-cont">开企业抬头发票须填写纳税人识别号，以免影响报销</span>
					</div>
					<div class="ui-switchable-panel">
						<div class="invoice_title p">
							<span class="label">发票抬头：</span>
							<div class="fl">
								<input class="invoice_tt" type="text" value="个人" onclick="hidediv();" id="personage" readonly="">
								<div id="adddiv" class="invoice_tt" style="display:none">
									<div class="fl" style="margin-left:-5px">
										<input class="invoice_tt" type="text" value="" id="invoice_title">
										<a onclick="save_invoice();" class="btn-9" style="margin-left:0px;margin-top: 5px">保存</a>
										<a onclick="togglediv();" class="btn-9" style="margin-left:0px;margin-top: 5px">取消</a>
									</div>
								</div>
								<br>
								<a onclick="togglediv()" href="javascript:void(0);" class="tp-addfp" id="addinvoice">新增单位发票</a>
							</div>
						</div>
						<div class="invoice_title p">
						</div>
						<div id="ratepaying" style="display:none" class="invoice_title p">
							<span class="label">纳税人编号：</span>
							<div class="fl">
								<input class="invoice_tt" type="text" value="" id="taxpayer">
							</div>
						</div>
						<div class="invoice_title p">
							<span class="label">发票内容：</span>
							<input type="hidden" name="invoice_desc" id="invoice_desc" value="不开发票">
							<div class="fl">
								<div class="tab-nav p">
									<ul id="invoice_class">
										<li>
											<div class="item_select_t curtr" id="no_invoice">
												<span>不开发票</span>
												<b></b>
											</div>
										</li>
										<li>
											<div class="item_select_t" id="detail_invoice">
												<span>明细</span>
												<b></b>
											</div>
										</li>
									</ul>
								</div>
							</div>
						</div>
						<script type="text/javascript">
							var invoice_type = $('#invoice_class');
							$("#invoice_desc").val(invoice_type.find('.curtr').find('span').text());
							invoice_type.find('li').click(function() {
								invoice_type.find('div').attr("class", "item_select_t");
								$("#invoice_desc").val($(this).find('span').text());
								$(this).find('div').attr("class", "item_select_t curtr");
							});
						</script>
						<div class="invoice_title p">
							<span class="label">&nbsp;</span>
							<div class="fl">
								<div class="op-btns  invoice_sendwithgift">
									<a id="invoiceBtn" class="btn-1">保存</a>
									<a onclick="$('.ui-dialog-close').trigger('click');" class="btn-9">取消</a>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="ui-mask"></div>
		<script type="text/javascript">
			// 添加刷选条件
		</script>
		<style>
			.rabbit {
				position: fixed;
				left: 50%;
				right: 50%;
				top: 50%;
				bottom: 50%;
				margin-top: -180px;
				margin-left: -300px;
				z-index: 9999;
				display: none;
			}
			
			.mask-filter-div {
				display: none;
				position: fixed;
				margin: 0 auto;
				width: 100%;
				left: 0;
				right: 0;
				top: 0;
				bottom: 0;
				z-index: 12;
				background: rgba(0, 0, 0, 0.4);
			}
		</style>
		<img class="rabbit" src="http://demo5.tp-shop.cn/public/images/qw.gif" alt="">
		<div class="mask-filter-div"></div>
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