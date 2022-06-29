<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <style>
    	*{
            margin: 0;
            padding: 0;
        }
        .flex_container{
            display: flex;
            flex-direction: column;
            width: 1200px;
            margin: 0 auto;
            font-size: 0px;
        }
        #member_bar{
            height: 50px;
            background-color: #e9e9e9;
            text-align: right;
        }
        #member_bar img{
            width: 50px;
            float: left;
        }
        #member_bar > div > p{
            width: 200px;
            float: left;
            font-size: 16px;
            text-align: left;
            padding-left: 5px;
            margin-top: 2px;
        }
        #member_bar > div{
            width: 300px;
            display: inline-block;
        } 
        nav{
            padding:20px 100px;
            background-color: #e9e9e9;
        }
        nav ul{
            list-style-type: none;
            display: flex;
            flex-direction: row;
            justify-content: space-around;
        }
       
        nav a:link,nav a:visited{
            font-size: 20px;
            font-weight: bold;
            text-decoration: none;
            color:black;
        }
        .ad_img {
            position: relative;
        }
        .ad_img button{
            background: none;
            border: none;
            position: absolute;
            background-color: rgba(255, 255, 255, 0.5);
            width: 50px;
            height: 50px;
        }
        .ad_img button img{
            width: 50px;
        }
        .left_arrow{
            top : calc(50% - 50px);
        }
        .right_arrow{
            top : calc(50% - 50px);
            right: 0px;
            transform: rotate(180deg);            
        }
    </style>

        <header>
	<div id="member_bar">
		<div>
			<img src="resource/images/profile.png" alt="">
			<p>OOO로그인 하셨습니다.</p>
			<p>로그아웃 | 정보수정</p>
		</div>
	</div>
	<div class="ad_img">
		<button class="left_arrow">
			<img src="resource/images/left_arrow.png" alt="">
		</button>
		<button class="right_arrow">
			<img src="resource/images/left_arrow.png" alt="">
		</button>
		<img src="resource/images/main_4.jpg" alt="">
	</div>
</header>
<nav>
	<ul>
		<li><a href="main.jsp">HOME</a></li>
		<li><a href="sub_page2.jsp">예약</a></li>
		<li><a href="#">펜션스토리</a></li>
		<li><a href="#">펜션소개</a></li>
		<li><a href="sub_page1.jsp">오시는길</a></li>
	</ul>
</nav>