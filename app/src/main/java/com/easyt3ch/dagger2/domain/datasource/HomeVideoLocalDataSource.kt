package com.easyt3ch.dagger2.domain.datasource

import com.easyt3ch.dagger2.db.dao.HomeVideoDao
import com.easyt3ch.dagger2.domain.model.Post
import javax.inject.Inject

class HomeVideoLocalDataSource @Inject constructor(private val homeVideoDao: HomeVideoDao) {

    fun getPosts() = homeVideoDao.getPosts()
    fun insertSources(posts: List<Post>) = homeVideoDao.insertReplacePosts(posts)

}
