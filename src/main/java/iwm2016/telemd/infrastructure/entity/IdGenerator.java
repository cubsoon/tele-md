package iwm2016.telemd.infrastructure.entity;

import java.util.UUID;

/**
 * Created by jakubk on 02.11.16.
 */
class IdGenerator {

    static String generateId() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
