package com.hemax.jkt.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QXueyuan is a Querydsl query type for Xueyuan
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QXueyuan extends EntityPathBase<Xueyuan> {

    private static final long serialVersionUID = 1215687108L;

    public static final QXueyuan xueyuan = new QXueyuan("xueyuan");

    public final NumberPath<Integer> access = createNumber("access", Integer.class);

    public final NumberPath<Integer> age = createNumber("age", Integer.class);

    public final StringPath cert = createString("cert");

    public final DatePath<java.util.Date> examinFour = createDate("examinFour", java.util.Date.class);

    public final DatePath<java.util.Date> examinOne = createDate("examinOne", java.util.Date.class);

    public final DatePath<java.util.Date> examinThree = createDate("examinThree", java.util.Date.class);

    public final DatePath<java.util.Date> examinTwo = createDate("examinTwo", java.util.Date.class);

    public final StringPath memo = createString("memo");

    public final StringPath name = createString("name");

    public final StringPath phone = createString("phone");

    public final NumberPath<Integer> step = createNumber("step", Integer.class);
    
    public final NumberPath<Integer> sex = createNumber("sex", Integer.class);

    public final DatePath<java.util.Date> time = createDate("time", java.util.Date.class);

    public QXueyuan(String variable) {
        super(Xueyuan.class, forVariable(variable));
    }

    public QXueyuan(Path<? extends Xueyuan> path) {
        super(path.getType(), path.getMetadata());
    }

    public QXueyuan(PathMetadata<?> metadata) {
        super(Xueyuan.class, metadata);
    }

}

