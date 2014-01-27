package ami.com.onlab.jobportal3;

import ami.com.onlab.jobportal3.Advertisement.Education;
import ami.com.onlab.jobportal3.Advertisement.PositionField;
import ami.com.onlab.jobportal3.Advertisement.Region;
import ami.com.onlab.jobportal3.Advertisement.Type;
import ami.com.onlab.jobportal3.Group;
import ami.com.onlab.jobportal3.User;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2013-12-18T18:55:31")
@StaticMetamodel(Advertisement.class)
public class Advertisement_ { 

    public static volatile SingularAttribute<Advertisement, Region> region;
    public static volatile SingularAttribute<Advertisement, Date> lastModified;
    public static volatile SingularAttribute<Advertisement, String> advText;
    public static volatile SingularAttribute<Advertisement, Type> type;
    public static volatile SingularAttribute<Advertisement, Education> education;
    public static volatile SingularAttribute<Advertisement, User> creator;
    public static volatile SingularAttribute<Advertisement, Date> creationDate;
    public static volatile SingularAttribute<Advertisement, String> title;
    public static volatile SingularAttribute<Advertisement, Long> advertisementID;
    public static volatile SingularAttribute<Advertisement, PositionField> positionField;
    public static volatile ListAttribute<Advertisement, Group> visibleFor;
    public static volatile SingularAttribute<Advertisement, String> positionName;
    public static volatile ListAttribute<Advertisement, User> candidates;

}