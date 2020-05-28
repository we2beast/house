package com.lab.house.hcs.services.impl

import com.lab.house.core.exceptions.AlreadyExistsException
import com.lab.house.core.exceptions.EntityNotFoundException
import com.lab.house.hcs.entities.House
import com.lab.house.hcs.repositories.ContractRepository
import com.lab.house.hcs.repositories.HouseRepository
import com.lab.house.hcs.services.HouseService
import com.lab.house.hcs.vo.house.HouseCreateRq
import com.lab.house.hcs.vo.house.HouseVO
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class HouseServiceImpl : HouseService {

    private val log = LoggerFactory.getLogger(HouseServiceImpl::class.java)

    @Autowired
    lateinit var houseRepository: HouseRepository

    @Autowired
    lateinit var contractRepository: ContractRepository

    @Throws(EntityNotFoundException::class)
    override fun getHouseById(id: String): HouseVO = houseRepository.findById(id.toLong()).map(::toHouseVO).orElseThrow { throw EntityNotFoundException("House with $id not found.") }

    @Throws(EntityNotFoundException::class)
    override fun getHouses(): List<HouseVO> {
        return houseRepository.findAll().map(::toHouseVO)
    }

    @Throws(EntityNotFoundException::class, AlreadyExistsException::class)
    override fun createHouse(houseCreateRq: HouseCreateRq): HouseVO {
        val contract = contractRepository.findFirstByBillNumber(houseCreateRq.contract) ?: throw EntityNotFoundException("Contract with ${houseCreateRq.contract} not found.")
        if (houseRepository.findFirstByHouseNumber(houseCreateRq.houseNumber) != null) throw AlreadyExistsException("House with ${houseCreateRq.houseNumber} already exist.")
        if (houseRepository.findFirstByContract(contract) != null) throw AlreadyExistsException("Contract with ${houseCreateRq.contract} already exist.")

        val id = houseRepository.save(House().apply {
            houseNumber = houseCreateRq.houseNumber
            this.contract = contract
        }).id ?: throw IllegalArgumentException("Bad id returned.")

        log.debug("Created entity $id")
        return getHouseById(id.toString())
    }

    @Throws(EntityNotFoundException::class)
    override fun updateHouse(id: String, houseCreateRq: HouseCreateRq): HouseVO {
        val contract = contractRepository.findFirstByBillNumber(houseCreateRq.contract) ?: throw EntityNotFoundException("Contract with ${houseCreateRq.contract} not found.")

        houseRepository.save(houseRepository.findById(id.toLong()).get().apply {
            houseNumber = houseCreateRq.houseNumber
            this.contract = contract
        }).id ?: throw IllegalArgumentException("Bad id returned.")

        log.debug("Updated entity $id")
        return getHouseById(id)
    }

    private fun toHouseVO(house: House): HouseVO {
        return HouseVO.fromData(house)
    }

}
