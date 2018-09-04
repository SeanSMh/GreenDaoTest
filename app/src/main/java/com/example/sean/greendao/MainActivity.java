package com.example.sean.greendao;

import android.media.session.MediaSession;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import java.util.List;

import GreenDao.greendao.db.DaoMaster;
import GreenDao.greendao.db.DaoSession;
import GreenDao.greendao.db.UserDao;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button query = (Button) findViewById(R.id.query);
        //获取数据库对象

        //查询数据
        //查询所有数据 List<User> users = mUserDao.loadAll();


        query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //user-db为数据库名称
                DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(MainActivity.this, "user-db", null);
                DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDatabase());
                DaoSession daoSession = daoMaster.newSession();
                UserDao userDao = daoSession.getUserDao();

                //输入一条数据，传null,id会自增
                userDao.insert(new User(1,"李华",23));
                userDao.insert(new User(2,"张伟",20));


                User user = userDao.queryBuilder()
                        .where(UserDao.Properties.Id.eq(2)).unique();
                Toast.makeText(MainActivity.this,user.getName(),Toast.LENGTH_SHORT).show();
            }
        });
    }
}
