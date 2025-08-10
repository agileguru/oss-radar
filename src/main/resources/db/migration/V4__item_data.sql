insert into item (item_name,item_desc,item_url,category,status,status_date)
	select 'Maven', 'Java based Build Tool' , 
		'https://maven.apache.org/', id, 'Adopt', '2020-07-22' from category where name = 'Tools'
union
	select 'Gradle', 'Gradle is an open-source build automation tool focused on flexibility and performance.',
		'https://gradle.org/', id, 'Hold', '2020-07-22' from category where name = 'Tools'
union
	select 'Ansible', 'Ansible is a simple IT automation engine to automate provisioning, configuration , deployment, orchestration and other IT needs',
		'https://www.ansible.com/', id, 'Adopt', '2020-07-22' from category where name = 'Tools'
union
	select 'Docker', 'Docker simplifies and accelerates your workflow, while giving developers the freedom to innovate with their choice of tools, application stacks, and deployment environments for each project',
		'https://www.docker.com/', id, 'Adopt', '2020-07-22' from category where name = 'Platforms'
union
	select 'Kubernetes', 'Docker simplifies and accelerates your workflow, while giving developers the freedom to innovate with their choice of tools, application stacks, and deployment environments for each project',
		'https://www.docker.com/', id, 'Adopt', '2020-07-22' from category where name = 'Platforms'
union
	select 'Argo CD', 'Argo CD is a declarative, GitOps continuous delivery tool for Kubernetes. It provides a GITOPS based Application definitions, configurations, and environments that is declarative, version controlled, auditable and easy to understand.',
		'https://argoproj.github.io/cd/', id, 'Adopt', '2024-01-15' from category where name = 'Tools'				
union
	select 'Kargo', 'Multi-Stage GitOps Continuous Promotion tool to seamlessly orchestrate stage-to-stage deployments, without custom scripts or CI pipelines.',
		'https://kargo.io/', id, 'Trial', '2024-01-15' from category where name = 'Tools'						
union
	select 'Argo Rollouts', 'Argo Rollouts is a Kubernetes controller and set of CRDs which provide advanced deployment capabilities such as blue-green, canary, canary analysis, experimentation, and progressive delivery features to Kubernetes.',
		'https://argoproj.github.io/rollouts/', id, 'Assess', '2024-03-15' from category where name = 'Tools'			
union
	select 'GitOps', 'GitOps is an operational framework that applies DevOps principles to infrastructure automation, using Git repositories as the single source of truth for infrastructure and application deployments.',
		'https://argoproj.github.io/rollouts/', id, 'Adopt', '2024-03-15' from category where name = 'Techniques'		
union
	select 'DevOps', 'DevOps is a software development approach that emphasizes collaboration and communication between development and operations teams',
		'https://en.wikipedia.org/wiki/DevOps', id, 'Adopt', '2015-04-10' from category where name = 'Techniques'				
union
	select 'Java', 'Java is a popular programming language. Java is used to develop mobile apps, web apps, desktop apps, games and much more.',
		'https://java.com', id, 'Adopt', '2015-02-19' from category where name = 'Languages / Frameworks'
union
	select 'Kotlin', 'Kotlin is a statically-typed, general-purpose programming language developed by JetBrains that is designed to be concise, safe, and interoperable with Java. ',
		'https://kotlinlang.org/', id, 'Assess', '2025-07-19' from category where name = 'Languages / Frameworks'
union
	select 'Pact CDC', 'Pact is a software technique used for consumer-driven contract (CDC) testing. It focuses on verifying interactions between software components by defining and enforcing contracts on how consumers expect providers to behave. ',
		'https://docs.pact.io/', id, 'Assess', '2025-04-10' from category where name = 'Techniques'
union
	select 'Google Cloud Platform (GCP)', 'Google Cloud Platform (GCP) is a suite of cloud computing services offered by Google. It provides a wide range of modular services for everything from computing and data storage to machine learning and data analytics.',
		'https://cloud.google.com/', id, 'Adopt', '2020-07-22' from category where name = 'Platforms'	
union
	select 'Amazon Web Services (AWS)', 'Amazon Web Services (AWS) is a subsidiary of Amazon and is the worlds most comprehensive and widely adopted cloud computing platform. It offers a vast array of services, providing on-demand computing platforms',
		'https://aws.amazon.com/?nc2=h_home', id, 'Adopt', '2024-02-21' from category where name = 'Platforms'
union
	select 'Python', 'Python is a popular, high-level, general-purpose programming language. Created by Guido van Rossum and first released in 1991, its design philosophy emphasizes code readability and a clean, easy-to-learn syntax, often using significant indentation.',
		'https://www.python.org/', id, 'Adopt', '2020-01-19' from category where name = 'Languages / Frameworks'
union
	select 'Spring-Boot', 'Spring Boot is an open-source Java framework used for programming Spring-based applications that make project configuration and features easier. It is a convention-over-configuration extension to help minimize configuration concerns.',
		'https://spring.io/projects/spring-boot', id, 'Adopt', '2015-06-29' from category where name = 'Languages / Frameworks'
union
	select 'REST-Assured', 'Testing and validating REST services in Java is harder than in dynamic languages such as Ruby and Groovy. REST Assured brings the simplicity of using these languages into the Java domain. You can easily use REST-Assured to validate your API. ',
		'https://rest-assured.io/', id, 'Adopt', '2015-06-29' from category where name = 'Languages / Frameworks'
union
	select 'Playwright', 'Playwright was created for end-to-end testing. Playwright supports rendering engines including Chromium, WebKit, and Firefox. It Runs Test on ALL OS, locally or on CI, having native mobile emulation of Google Chrome for Android and Mobile Safari.',
		'https://playwright.dev/', id, 'Assess', '2025-07-29' from category where name = 'Languages / Frameworks'				

;