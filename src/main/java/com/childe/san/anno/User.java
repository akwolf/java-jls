package com.childe.san.anno;


/**
 * @author zhangh
 * @createTime 2013-6-21 下午3:44:43
 */
@TypeAnnotation
public class User {
	@FieldAnnotation
	private int age;

	@ConstructorAnnotation
	private User() {
	}

	public int getAge() {
		return age;
	}

	@MethodAnnotation
	public void setAge(int age) {
		this.age = age;
	}

}
