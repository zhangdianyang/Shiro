package test.solr;

import java.io.Serializable;

public class SearchPage implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 页码 */
    private int               pageNumber       = 1;

    /** 每页记录数 */
    private int               pageSize         = 10;

    /** 总记录数 */
    private int               totalCount;

    /** 排序字段 */
    private String[]          orderType;

    /**
     * 查询关键字
     */
    private String            keyword;

    /** 多条件查询 */
    private String            selectParam;

    /** 默认查询字段 */
    private String            field;

    private int               Start            = 0;
	// 省略get和set
    
}
