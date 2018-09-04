package com.example.sean.greendao;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Transient;
import org.greenrobot.greendao.annotation.Unique;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class User {

  @Id (autoincrement = true) //指明id
    private long id;
  @Unique
  @NotNull

  @Property (nameInDb = "username")//属性字段
    private String name;
  @NotNull

    private int age;

  @Transient
    private String info;

  @Generated(hash = 1198735498)
  public User(long id, @NotNull String name, int age) {
      this.id = id;
      this.name = name;
      this.age = age;
  }

  @Generated(hash = 586692638)
  public User() {
  }

  public long getId() {
      return this.id;
  }

  public void setId(long id) {
      this.id = id;
  }

  public String getName() {
      return this.name;
  }

  public void setName(String name) {
      this.name = name;
  }

  public int getAge() {
      return this.age;
  }

  public void setAge(int age) {
      this.age = age;
  }

}
