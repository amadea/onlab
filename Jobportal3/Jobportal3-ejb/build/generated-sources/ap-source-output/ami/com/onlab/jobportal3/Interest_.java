package ami.com.onlab.jobportal3;

import ami.com.onlab.jobportal3.Advertisement.Education;
import ami.com.onlab.jobportal3.Advertisement.PositionField;
import ami.com.onlab.jobportal3.Advertisement.Region;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2013-12-18T18:55:31")
@StaticMetamodel(Interest.class)
public class Interest_ { 

    public static volatile SingularAttribute<Interest, Region> region;
    public static volatile SingularAttribute<Interest, Long> interestID;
    public static volatile SingularAttribute<Interest, Date> creationDate;
    public static volatile SingularAttribute<Interest, Date> lastModified;
    public static volatile SingularAttribute<Interest, String> name;
    public static volatile SingularAttribute<Interest, PositionField> PositionField;
    public static volatile SingularAttribute<Interest, Education> education;
    public static volatile SingularAttribute<Interest, String> keyWord;

}