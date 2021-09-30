package com.noxstudy.persistent.entity;

import com.noxstudy.common.enums.AuthorityName;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Authority.class)
public abstract class Authority_ extends com.noxstudy.persistent.entity.BaseTimestampEntity_ {

	public static volatile SingularAttribute<Authority, AuthorityName> name;
	public static volatile SingularAttribute<Authority, Long> id;

	public static final String NAME = "name";
	public static final String ID = "id";

}

