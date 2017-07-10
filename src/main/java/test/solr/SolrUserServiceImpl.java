package test.solr;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class SolrUserServiceImpl implements ISolrUserService {
	
	
	public static final String urlString = "http://localhost:8983/solr/jcg";
	
	SolrClient solrClient = new HttpSolrClient(urlString);
	
	private SearchUserDTO toSearchUser(User user) throws IllegalAccessException, InvocationTargetException {
        SearchUserDTO userDTO = new SearchUserDTO();
		// 此方法是将user中属性的值复制到userDTO属性，这个方法是复制类中属性名一样的属性值
        BeanUtils.copyProperties(user, userDTO);
        return userDTO;
    }

	

	@Override
	public boolean createUserIndex(List<User> userLists) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUserIndex(List<String> custNos) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public QueryResult<SearchUserDTO> queryUser(SearchPage page) {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public boolean createUserIndex(User user) {
		// TODO Auto-generated method stub
		return false;
	}

   
}
