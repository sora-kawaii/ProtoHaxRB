/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  kotlin.Metadata
 */
package dev.sora.relay.game.utils.constants;

import kotlin.Metadata;

@Metadata(d1={"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0005\u00a2\u0006\u0002\u0010\u0002\u00a8\u0006\u0007"}, d2={"Ldev/sora/relay/game/utils/constants/TransactionActionType;", "", "()V", "inventoryMismatch", "releaseItem", "useItem", "useItemOnEntity", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
public final class TransactionActionType {

    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2={"Ldev/sora/relay/game/utils/constants/TransactionActionType$inventoryMismatch;", "", "()V", "DROP_ITEM", "", "PICKUP_ITEM", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
    public static final class inventoryMismatch {
        public static final int DROP_ITEM = 0;
        public static final inventoryMismatch INSTANCE = new inventoryMismatch();
        public static final int PICKUP_ITEM = 1;

        private inventoryMismatch() {
        }
    }

    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2={"Ldev/sora/relay/game/utils/constants/TransactionActionType$releaseItem;", "", "()V", "CONSUME", "", "RELEASE", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
    public static final class releaseItem {
        public static final int CONSUME = 1;
        public static final releaseItem INSTANCE = new releaseItem();
        public static final int RELEASE = 0;

        private releaseItem() {
        }
    }

    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2={"Ldev/sora/relay/game/utils/constants/TransactionActionType$useItem;", "", "()V", "BREAK_BLOCK", "", "CLICK_AIR", "CLICK_BLOCK", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
    public static final class useItem {
        public static final int BREAK_BLOCK = 2;
        public static final int CLICK_AIR = 1;
        public static final int CLICK_BLOCK = 0;
        public static final useItem INSTANCE = new useItem();

        private useItem() {
        }
    }

    @Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2={"Ldev/sora/relay/game/utils/constants/TransactionActionType$useItemOnEntity;", "", "()V", "ATTACK", "", "INTERACT", "ProtoHax"}, k=1, mv={1, 7, 1}, xi=48)
    public static final class useItemOnEntity {
        public static final int ATTACK = 1;
        public static final useItemOnEntity INSTANCE = new useItemOnEntity();
        public static final int INTERACT = 0;

        private useItemOnEntity() {
        }
    }
}

