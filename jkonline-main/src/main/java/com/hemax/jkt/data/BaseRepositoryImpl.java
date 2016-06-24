package com.hemax.jkt.data;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.QueryDslJpaRepository;
import org.springframework.data.querydsl.EntityPathResolver;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;
import com.hemax.jkt.util.BeanUtil;

import javax.persistence.EntityManager;

import java.io.Serializable;

/**
 * @author hongzheng.liu
 */
@NoRepositoryBean
public class BaseRepositoryImpl<T, ID extends Serializable> extends QueryDslJpaRepository<T, ID> implements BaseRepository<T, ID> {

    private EntityManager em;


    @SuppressWarnings("unchecked")
    public BaseRepositoryImpl(JpaEntityInformation<T, ?> jpaEntityInformation, EntityManager em) {
        super((JpaEntityInformation<T, ID>) jpaEntityInformation, em);
        this.em = em;
    }

    public BaseRepositoryImpl(JpaEntityInformation<T, ID> entityInformation, EntityManager em,
                              EntityPathResolver resolver) {
        super(entityInformation, em, resolver);
        this.em = em;
    }

    /*
     * (non-Javadoc)
     * @see com.crunii.uie.core.data.UpdateRepository#update(java.lang.Object, java.lang.String[])
     */
    @Override
    @Transactional
    public T updateAttributes(ID id, T entity, String... attributes) {
        if (attributes == null || attributes.length == 0) {
            em.merge(entity);

            return entity;
        } else {
            T p = em.find(super.getDomainClass(), id);
            BeanUtil.copyPermittedProperties(entity, p, attributes);

            return p;
        }
    }
}
