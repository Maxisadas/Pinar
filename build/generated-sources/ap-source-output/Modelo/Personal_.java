package Modelo;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Personal.class)
public abstract class Personal_ {

	public static volatile SingularAttribute<Personal, Area> area;
	public static volatile SingularAttribute<Personal, Date> fechaBaja;
	public static volatile SingularAttribute<Personal, Date> fechaAlta;
	public static volatile SingularAttribute<Personal, String> apellido;
	public static volatile SingularAttribute<Personal, Long> id;
	public static volatile SingularAttribute<Personal, String> nombre;
	public static volatile SingularAttribute<Personal, String> dni;
	public static volatile SingularAttribute<Personal, Rol> rol;

}

