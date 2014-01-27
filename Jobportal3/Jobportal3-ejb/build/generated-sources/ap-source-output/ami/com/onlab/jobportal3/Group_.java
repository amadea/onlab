package ami.com.onlab.jobportal3;

import ami.com.onlab.jobportal3.Advertisement;
import ami.com.onlab.jobportal3.User;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2013-12-18T18:55:31")
@StaticMetamodel(Group.class)
public class Group_ { 

    public static volatile SingularAttribute<Group, byte[]> picture;
    public static volatile SingularAttribute<Group, Long> groupID;
    public static volatile ListAttribute<Group, Advertisement> commonAdvertisements;
    public static volatile SingularAttribute<Group, String> description;
    public static volatile SingularAttribute<Group, String> name;
    public static volatile ListAttribute<Group, User> members;

}