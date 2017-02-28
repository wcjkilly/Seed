var a = 1,
b = "img/head/2024.jpg",
c = "img/head/2015.jpg",
d = "\u738b\u65ed";

//消息闪烁
function message() {
    var a = $.blinkTitle.show();
    setTimeout(function() {
        $.blinkTitle.clear(a)
    },
    8e3)
}

//时间不足两位的补0
function checkTime(i){
	if (i<10){
		i="0" + i;
	}
	return i;
}

//发送消息
function e() {
	//将图片表情转换成图片显示
	function h() { - 1 != g.indexOf("*#emo_") && (g = g.replace("*#", "<img src='img/").replace("#*", ".gif'/>"), h())
	}
    var e = new Date(),
    f = "";
    var hou= e.getHours();
    var min= e.getMinutes();
    var sou= e.getSeconds();
    hou=checkTime(hou);
    min=checkTime(min);
    sou=checkTime(sou);
    f=hou+":"+min+":"+sou;
    //获取发送消息内容
    var g = $("#textarea").val();
    //在要发送的消息前加前缀，用于标识要发送给谁
    var gtemp = $(".talkTo a").text() + "__####__" + $("#textarea").val();
    h();
    
	var i = "<div class='message clearfix'><div class='user-logo' style='border-radius: 50%;overflow: hidden;'><img src='" + b + "'/>" 
	+ "</div>" + "<div class='wrap-text'>"  + "<div>" + 
	g + "</div>" + "</div>" + "<div class='wrap-ri'>" + "<div clsss='clearfix'><span>" + f + "</span></div>" + "</div>"
	+ "<div style='clear:both;'></div>" + "</div>"
    
	null != g && "" != g ? ($(".mes" + a).append(i), $(".chat01_content").scrollTop($(".mes" + a).height()), $("#textarea").val(""),ws.send(gtemp)) : alert("\u8bf7\u8f93\u5165\u804a\u5929\u5185\u5bb9!")
};
//初始化聊天窗口事件监听
function initListener(){
	$(".close_btn").click(function() {
        $(".chatBox").hide()
    }),
    $(".chat03_content li").mouseover(function() {
        $(this).addClass("hover").siblings().removeClass("hover")
    }).mouseout(function() {
        $(this).removeClass("hover").siblings().removeClass("hover")
    }),
    $(".chat03_content li").dblclick(function() {
        var b = $(this).index() + 1;
        a = b,
        c = "img/head/2016.jpg",
        d = $(this).find(".chat03_name").text(),
        $(".chat01_content").scrollTop(0),
        $(this).addClass("choosed").siblings().removeClass("choosed"),
        $(".talkTo a").text($(this).children(".chat03_name").text()),
        $(".mes" + b).show().siblings().hide()
    }),
    $(".ctb01").mouseover(function() {
        $(".wl_faces_box").show()
    }).mouseout(function() {
        $(".wl_faces_box").hide()
    }),
    $(".wl_faces_box").mouseover(function() {
        $(".wl_faces_box").show()
    }).mouseout(function() {
        $(".wl_faces_box").hide()
    }),
    $(".wl_faces_close").click(function() {
        $(".wl_faces_box").hide()
    }),
    $(".wl_faces_main img").click(function() {
        var a = $(this).attr("src");
        $("#textarea").val($("#textarea").val() + "*#" + a.substr(a.indexOf("img/") + 4, 6) + "#*"),
        $("#textarea").focusEnd(),
        $(".wl_faces_box").hide()
    }),
    $(".chat02_bar img").click(function() {
        e()
    }),
    document.onkeydown = function(a) {
        var b = document.all ? window.event: a;
        return 13 == b.keyCode ? (e(), !1) : void 0
    },
    $.fn.setCursorPosition = function(a) {
        return 0 == this.lengh ? this: $(this).setSelection(a, a)
    },
    $.fn.setSelection = function(a, b) {
        if (0 == this.lengh) return this;
        if (input = this[0], input.createTextRange) {
            var c = input.createTextRange();
            c.collapse(!0),
            c.moveEnd("character", b),
            c.moveStart("character", a),
            c.select()
        } else input.setSelectionRange && (input.focus(), input.setSelectionRange(a, b));
        return this
    },
    $.fn.focusEnd = function() {
        this.setCursorPosition(this.val().length)
    }
};

$(document).ready(function() {
	
	ws = new WebSocket("ws://localhost:9080/Seed/websocket");
	ws.onopen = function() {
		//连接服务器成功后加载用户列表，并设置相应的监听事件
		$.ajax({
			type:'get',
			url:'chatAllUsers.action',
			dataType: 'json',
			success:function(data){
				$.each(data.list,function(i,item){
					var temp1 = "";
					var temp2 = "";
					if(i==0){
						temp1 = "<li class='choosed'><label class='online'></label><a href='javascript:;'><img src='img/head/2016.jpg'></a><a href='javascript:;' class='chat03_name'>"+item.username+"</a></li>";
						temp2 = "<div class='message_box mes1' style='display: block;'></div>";
						$(".talkTo a").text(item.username);
					}else{
						temp1 = "<li><label class='offline'></label><a href='javascript:;'><img src='img/head/2016.jpg'></a><a href='javascript:;' class='chat03_name'>"+item.username+"</a></li>";
						temp2 = "<div class='message_box mes"+(i+1)+"'></div>";
					}
					//alert(temp1);
					//alert(temp2);
					$(".chat03_content ul").append(temp1);
					$(".chat01_content").append(temp2);
				}),
				//初始化监听
				initListener()
			}
		});
	};
	ws.onmessage = function(evn) {
		//将图片表情转换成图片显示
		function h() { - 1 != g.indexOf("*#emo_") && (g = g.replace("*#", "<img src='img/").replace("#*", ".gif'/>"), h())
		}
        var e = new Date(),
        f = "";
        var hou= e.getHours();
        var min= e.getMinutes();
        var sou= e.getSeconds();
        hou=checkTime(hou);
        min=checkTime(min);
        sou=checkTime(sou);
        f=hou+":"+min+":"+sou;
        var g = evn.data;
        h();
        
		var i = "<div class='message clearfix'>" + "<div class='user-logo' style='float:right;border-radius: 50%;overflow: hidden;'>" + "<img src='" + c + "'/>"
		+ "</div>" + "<div class='wrap-text' style='float:right;margin-right:10px;'>"  + "<div style='text-align:right'>" + 
		g + "</div>" + "</div>" + "<div class='wrap-ri'>" + 
		"<div clsss='clearfix' style='right: 88%;'><span>" + f + "</span></div>" + "</div>" + "<div style='clear:both;'></div>";
		
		//将接收到的消息显示在对应用户的面板区间内
		var msg_user = g.split(":")[0];
        console.log(msg_user);
        $(".chat03_content ul li").each(function(index){
        	temp_index = $(this).index() + 1;
            temp_user = $(this).find(".chat03_name").text();
            console.log(temp_index+"###"+temp_user);
            if(temp_user==msg_user){
            	$(".mes" + temp_index).append(i);
            }
        });
		
		message();
	};
	ws.onclose = function() {
		alert("断开与服务器的连接");
	};
}),
function(a) {
    a.extend({
        blinkTitle: {
            show: function() {
                var a = 0,
                b = document.title;
                if ( - 1 == document.title.indexOf("\u3010")) var c = setInterval(function() {
                    a++,
                    3 == a && (a = 1),
                    1 == a && (document.title = "\u3010\u3000\u3000\u3000\u3011" + b),
                    2 == a && (document.title = "\u3010\u65b0\u6d88\u606f\u3011" + b)
                },
                500);
                return [c, b]
            },
            clear: function(a) {
                a && (clearInterval(a[0]), document.title = a[1])
            }
        }
    })
} (jQuery);