package cn.edu.jit.service.impl;

import cn.edu.jit.entry.Article;
import cn.edu.jit.entry.ArticleExample;
import cn.edu.jit.mapper.ArticleMapper;
import cn.edu.jit.mapper.TagMapper;
import cn.edu.jit.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jitwxs
 * @date 2018/1/3 13:19
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleMapper articleMapper;

    @Autowired
    TagMapper tagMapper;

    @Override
    public int save(Article article) {
        return articleMapper.insertSelective(article);
    }

    @Override
    public int removeById(String id) {
        return articleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int update(Article article) {
        return articleMapper.updateByPrimaryKey(article);
    }

    @Override
    public Article getById(String id) {
        return articleMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Article> listSbTitle(String uid, String title) {
        ArticleExample articleExample = new ArticleExample();

        ArticleExample.Criteria criteria = articleExample.createCriteria();
        criteria.andUserIdEqualTo(uid);
        criteria.andTitleLike(title);

        return articleMapper.selectByExample(articleExample);
    }

    @Override
    public List<Article> listSbByTag(String uid, String tagId) {
        return  articleMapper.listSbByTag(uid, tagId);
    }

    @Override
    public int countSbArticle(String uid) {
        ArticleExample articleExample = new ArticleExample();

        ArticleExample.Criteria criteria = articleExample.createCriteria();
        criteria.andUserIdEqualTo(uid);

        return articleMapper.countByExample(articleExample);
    }


}