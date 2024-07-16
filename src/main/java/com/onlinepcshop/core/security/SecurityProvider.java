package com.onlinepcshop.core.security;



public interface SecurityProvider {

//    /**
//     * Creates a principal on authorization server from the given operator.
//     *
//     * @param operator
//     * @return Principal ID, as set on the authorization server
//     */
//    String createPrincipal(Operator operator);

    default void authorize() {}

    default void assignRoles(String principalId, Role... roles) {}

    default void initialize() {}

    default void deletePrincipal(String principalId) {}

    void updatePrincipal(String principalId, String newEmail);

//    default void updatePrincipal(Vlasnik vlasnik) {}

    default void changePassword(String principalId, String newPassword) {}
}