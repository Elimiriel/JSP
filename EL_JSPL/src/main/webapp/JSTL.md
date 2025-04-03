# JSTL(JSP Standard Tag Library)

- JSP 페이지에서 스크립트릿(자바 코드)과 HTML 코드가
  뒤 섞이게 되는 현상이 발생을 함.
- 이렇게 뒤 섞인 코드는 알아보기가 쉽지 않게 되는 단점이 발생함.
  따라서 가독성이 낮아짐.
- JSP 페이지에서 스크립트릿에 들어가는 자바 코드 중에 논리적인
  판단, 반복 처리, 포멧 처리 등을 HTML 태그처럼 사용할 수
  있도록 표준으로 만들어서 정의한 것이 JSTL 라이브러리임.
- JSTL을 사용하기 위해서는 라이브러리 파일이 필요함: tomcat taglibs or elsewheres

  <!-- 
  	jstl 라이브러리 다운로드

  	https://archive.apache.org/dist/jakarta/taglibs/standard/binaries/
  	v1.1.0 in class
   -->

  * jstl.jar
  * standard.jar

## Formatting

포맷팅 라이브러리 종류
        -[fmt:formatNumber](fmt:formatNumber) : 표시할 숫자의 형식을 지정하는 태그.
        - [fmt:timeZone](fmt:timeZone) : 지정한 국가의 시간을 지정하는 태그.
                           태그를 열고 닫는 영역에서만 적용이 됨.
        - [fmt:setTimeZone](fmt:setTimeZone) : 지정한 국가의 시간을 지정하는 태그.
        - [fmt:formatDate](fmt:formatDate) : 지정한 형식의 날짜를 표시하는 태그.

    [fmt:formatNumber](fmt:formatNumber) 태그의 여러 가지 속성.
         - value : 출력의 형식을 지정함.
         - type : 츨력의 타입을 지정함.
                  * percent : %
                  * number : 숫자
                  * currency : 통화 형식
         - currencyCode : 통화 코드를 지정함. 한국의 원화는 KRW임.
         - currencySymbol : 통화를 표시할 때 사용할 기호를 표시함.
         - var : [fmt:formatNumber](fmt:formatNumber) 태그의 결과를 저장할 변수의 이름을 지정.
         - scope : 변수의 접근 범위를 지정함.
         - pattern : 숫자가 출력될 양식을 지정함.
