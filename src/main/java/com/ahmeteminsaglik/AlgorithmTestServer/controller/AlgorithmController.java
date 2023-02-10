package com.ahmeteminsaglik.AlgorithmTestServer.controller;

import com.ahmeteminsaglik.AlgorithmTestServer.business.TestAlgorithmFactory;
import org.ahmeteminsaglik.AvailableAlgorithm;
import org.ahmeteminsaglik.TestAlgorithm;
import org.ahmeteminsaglik.TestAlgorithmResult;
import org.ahmeteminsaglik.enums.EnumDataStructor;
import org.ahmeteminsaglik.enums.EnumSearchAlgorithm;
import org.ahmeteminsaglik.enums.EnumSortAlgorithm;
import org.ahmeteminsaglik.searchnode.utilities.SuccessDataResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@CrossOrigin
@RestController
@RequestMapping("/v1/")
public class AlgorithmController {

    @GetMapping("")
    public String gethello() {
        return "Hello world";
    }

    /*
     * TODO burdan test alorithm.test() ile db connecton yapilirken sorun cikiyor. saveleme islemleri ve empty statement hata veriyor */
    @GetMapping("datastructor")
    public SuccessDataResult<List<EnumDataStructor>> getDataStructor() {
        SuccessDataResult<List<EnumDataStructor>> data = new SuccessDataResult<>(new AvailableAlgorithm().getAvailableEnumDataStructorList(), "Data is retrived");
        return data;
    }

    @GetMapping("sortalgorithm")
    public SuccessDataResult<List<EnumSortAlgorithm>> getSortAlgorithm(@RequestParam EnumDataStructor enumDataStructor) {
        SuccessDataResult<List<EnumSortAlgorithm>> data = new SuccessDataResult<>(new AvailableAlgorithm().getAvailableEnumSortAlgorithmListWithGivenDataStructor(enumDataStructor), "Data is retrived");
        return data;
    }
    /*@PostMapping("sortalgorithm")
    public SuccessDataResult<List<EnumSortAlgorithm>> getSortAlgorithm(@RequestBody EnumDataStructor enumDataStructor) {
        SuccessDataResult<List<EnumSortAlgorithm>> data = new SuccessDataResult<>(new AvailableAlgorithm().getAvailableEnumSortAlgorithmListWithGivenDataStructor(enumDataStructor), "Data is retrived");
        return data;
    }*/

    @GetMapping("searchalgorithm")
    public SuccessDataResult<List<EnumSearchAlgorithm>> getSearchAlgorithm(@RequestParam EnumDataStructor enumDataStructor) {
        SuccessDataResult<List<EnumSearchAlgorithm>> data = new SuccessDataResult<>(new AvailableAlgorithm().getAvailableEnumSearchAlgorithmListWithGivenDataStructor(enumDataStructor), "Data is retrived");
        return data;
    }
    @PostMapping("getResult")
    public TestAlgorithmResult testAlgorithm(/*@RequestBody TestAlgorithmResult testAlgorithmResult*/) {
//        TestAlgorithm testAlgorithm= new TestAlgorithm();
        TestAlgorithmFactory factory = new TestAlgorithmFactory();
        TestAlgorithmResult result = factory.build();
//        System.out.println("testAlgorithmResult --> to String --> : "+testAlgorithmResult);
//        testAlgorithm.test(testAlgorithmResult);
        return result;
    }
    @PostMapping("test")
    public SuccessDataResult<TestAlgorithmResult> testAlgorithm(@RequestBody TestAlgorithmResult testAlgorithmResult) {
        TestAlgorithm testAlgorithm= new TestAlgorithm();
        System.out.println("testAlgorithmResult --> to String --> : "+testAlgorithmResult);
        testAlgorithm.test(testAlgorithmResult);
        return new SuccessDataResult<>(testAlgorithmResult, "Algorithm is tested");
    }
}
