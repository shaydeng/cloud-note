package cn.edu.jit.service;

import cn.edu.jit.entry.ArticleRecycle;

import java.util.List;

/**
 * @author jitwxs
 * @date 2018/1/3 13:19
 */
public interface ArticleRecycleService {

    int save(ArticleRecycle articleRecycle);

    ArticleRecycle getById(String id);

    int removeById(String id);

    List<ArticleRecycle> listSelfRecycle(String uid);
}
