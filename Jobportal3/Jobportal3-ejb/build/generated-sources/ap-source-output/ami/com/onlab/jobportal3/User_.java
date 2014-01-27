package ami.com.onlab.jobportal3;

import ami.com.onlab.jobportal3.Advertisement;
import ami.com.onlab.jobportal3.Group;
import ami.com.onlab.jobportal3.Interest;
import ami.com.onlab.jobportal3.User.Gender;
import ami.com.onlab.jobportal3.User.Nationality;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2013-12-18T18:55:31")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, String> lastName;
    public static volatile SingularAttribute<User, String> phone;
    public static volatile ListAttribute<User, Interest> interests;
    public static volatile SingularAttribute<User, String> password;
    public static volatile SingularAttribute<User, byte[]> picture;
    public static volatile SingularAttribute<User, Long> userID;
    public static volatile ListAttribute<User, Advertisement> appliedAdvertisements;
    public static volatile SingularAttribute<User, Nationality> nationality;
    public static volatile SingularAttribute<User, String> email;
    public static volatile SingularAttribute<User, String> address;
    public static volatile SingularAttribute<User, byte[]> CVFile;
    public static volatile SingularAttribute<User, Gender> gender;
    public static volatile SingularAttribute<User, String> userName;
    public static volatile SingularAttribute<User, Date> birthDate;
    public static volatile SingularAttribute<User, String> firstName;
    public static volatile ListAttribute<User, Advertisement> createdAdvertisements;
    public static volatile ListAttribute<User, Group> groups;
    public static volatile SingularAttribute<User, String> skype;

}