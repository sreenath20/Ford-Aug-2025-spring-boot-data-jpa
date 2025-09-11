plugins {
	java
	id("org.springframework.boot") version "3.5.5"
	id("io.spring.dependency-management") version "1.1.7"
}

group = "com.abc"
version = "0.0.1-SNAPSHOT"
description = "Demo project for Spring Boot data JPA "

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(17)
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation("org.springframework.boot:spring-boot-starter-web")
	runtimeOnly("com.h2database:h2")
	implementation ("org.springframework.boot:spring-boot-starter-validation")
	// http://localhost:8080/swagger-ui/index.html
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.8.8")
// Use the latest compatible version
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
