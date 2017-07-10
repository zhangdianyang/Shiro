package test.solr;

import java.util.List;

/**
 * 
 * 前面文章中说过了，是对系统的优化，假如之前数据库中保存的数据是用户的信息
 * User：username,age,email,custNo;
 *
 */
public interface ISolrUserService {

    /**
     *  一句话功能描述：创建用户索引数据
     */
    public boolean createUserIndex(User user);
    /**
     * 一句话功能描述：批量创建用户索引数据
     */
    public boolean createUserIndex(List<User> userLists);
    /**
     * 一句话功能描述：批量删除用户索引数据
     */
    public boolean deleteUserIndex(List<String> custNos);
    /**
     * 一句话功能描述：查询用户数据
     */
    public QueryResult<SearchUserDTO> queryUser(SearchPage page);
}
