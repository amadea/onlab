/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ami
 */
import com.sun.faces.application.ApplicationAssociate;
import com.sun.faces.mgbean.BeanBuilder;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.faces.context.FacesContext;

public class BeanManager {
    
    public static void main(String[] args){
    
    ApplicationAssociate application = ApplicationAssociate.getInstance(FacesContext.getCurrentInstance().getExternalContext());
    com.sun.faces.mgbean.BeanManager beanManager = application.getBeanManager();
Map<String, BeanBuilder> beanMap = beanManager.getRegisteredBeans();
Set<Entry<String, BeanBuilder>>beanEntries = beanMap.entrySet();

for (Entry<String, BeanBuilder> bean: beanEntries){
  String beanName = bean.getKey();
  if (beanManager.isManaged(beanName)) {
    BeanBuilder builder = bean.getValue();
    System.out.println("Bean name: " + beanName);
    System.out.println("Bean class: " + builder.getBeanClass());
    System.out.println("Bean scope: " + builder.getScope());
  }
}
    }
}
