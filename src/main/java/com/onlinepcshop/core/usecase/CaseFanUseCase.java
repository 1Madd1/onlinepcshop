package com.onlinepcshop.core.usecase;

import com.onlinepcshop.core.domain.entity.CaseFan;
import com.onlinepcshop.core.domain.entity.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CaseFanUseCase {
    /***
     *  Create and persist an agent
     *
     * @param caseFan newly created case fan
     * @return Valid user object with id
     */
    CaseFan createCaseFan(CaseFan caseFan);

    /***
     *  Update caseFan data fields
     * @param caseFan must be a valid case fan object with valid id
     * @return Updated caseFan object
     */
    CaseFan updateCaseFan(CaseFan caseFan);

    /***
     *
     * @return List of all case fans
     */
    List<CaseFan> findAllCaseFans();


    /***
     * @param caseFanId valid caseFan UUID
     * @return CaseFan with provided agentId if one exists
     */
    Optional<CaseFan> findCaseFanById(UUID caseFanId);

    /***
     * Delete case fan with specified id
     * @param id must be a valid
     */
    void deleteCaseFan(UUID id);
}
