package com.hemax.jkt.domain;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;


/**
 * QMsg is a Querydsl query type for Msg
 */
@Generated("com.mysema.query.codegen.EntitySerializer")
public class QMsg extends EntityPathBase<Msg> {

    private static final long serialVersionUID = 948498804L;

    public static final QMsg msg = new QMsg("msg");

    public final StringPath account = createString("account");

    public final StringPath batchSeqNo = createString("batchSeqNo");

    public final StringPath content = createString("content");

    public final DateTimePath<java.util.Date> createTime = createDateTime("createTime", java.util.Date.class);

    public final StringPath id = createString("id");

    public final StringPath msgChannel = createString("msgChannel");

    public final StringPath msgSp = createString("msgSp");

    public final NumberPath<Integer> msgType = createNumber("msgType", Integer.class);

    public final StringPath params = createString("params");

    public final StringPath partnerCode = createString("partnerCode");

    public final StringPath productCode = createString("productCode");

    public final StringPath reason = createString("reason");

    public final StringPath seqNo = createString("seqNo");

    public final StringPath sourceSystem = createString("sourceSystem");

    public final NumberPath<Integer> status = createNumber("status", Integer.class);

    public final StringPath templateCode = createString("templateCode");

    public final StringPath tunnel = createString("tunnel");

    public final StringPath tunnelSeqNo = createString("tunnelSeqNo");

    public final DateTimePath<java.util.Date> updateTime = createDateTime("updateTime", java.util.Date.class);

    public final NumberPath<java.math.BigInteger> userId = createNumber("userId", java.math.BigInteger.class);

    public QMsg(String variable) {
        super(Msg.class, forVariable(variable));
    }

    public QMsg(Path<? extends Msg> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMsg(PathMetadata<?> metadata) {
        super(Msg.class, metadata);
    }

}

