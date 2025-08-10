insert into item (item_name,item_desc,item_url,category,status,status_date)
	select 'Mocking', 'Mocking is a software testing technique where simulated or "mock" objects are used to replace real components during testing. This allows making testing more controlled and efficient by avoiding dependencies on external dependencies. ' , 
		'https://maven.apache.org/', id, 'Adopt', '2020-07-22' from category where name = 'Techniques'
union
	select 'Wildfly', 'A powerful, modular, & lightweight application server that helps you build java based applications. It is used to build java based web and API applications using maven build tool. It is quite an well established opiniated technolgy stack ',
		'https://www.wildfly.org/', id, 'Hold', '2020-07-22' from category where name = 'Platforms'		
union
	select 'Tomcat', 'The Apache Tomcat® software is an open source implementation of the Jakarta Servlet, Jakarta Pages, Jakarta Expression Language, Jakarta WebSocket, Jakarta Annotations and Jakarta Authentication specifications as part of the Jakarta EE platform.',
		'https://tomcat.apache.org/', id, 'Adopt', '2015-06-29' from category where name = 'Platforms'

;