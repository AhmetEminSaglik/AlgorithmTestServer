package com.ahmeteminsaglik.AlgorithmTestServer;

import org.ahmeteminsaglik.API.concretes.DatabaseConnectionSN;
import org.ahmeteminsaglik.TestAlgorithm;
import org.ahmeteminsaglik.TestAlgorithmResult;
import org.ahmeteminsaglik.abstracts.set.api.SetTestResultService;
import org.ahmeteminsaglik.entity.WordProcessUsedTable;
import org.ahmeteminsaglik.enums.EnumDataStructor;
import org.ahmeteminsaglik.enums.EnumSearchAlgorithm;
import org.ahmeteminsaglik.enums.EnumSortAlgorithm;
import org.ahmeteminsaglik.enums.EnumWordTable;

public class Main {

    public static void main(String[] args) {
        TestAlgorithmResult testAlgorithmResult = buildFakeTestAlgorithmResult();
        TestAlgorithm testAlgorithm = new TestAlgorithm();
        testAlgorithm.test(testAlgorithmResult);
        DatabaseConnectionSN connectionSN= new DatabaseConnectionSN();
        connectionSN.save(testAlgorithmResult);
    }

    static TestAlgorithmResult buildFakeTestAlgorithmResult() {
        SetTestResultService setResultService = new TestAlgorithmResult();
        WordProcessUsedTable wordProcessUsedTable = new WordProcessUsedTable(EnumWordTable.WORD_250, EnumWordTable.WORD_100);
        setResultService
                .setDataStructorProcess(EnumDataStructor.ARRAYLIST)
                .setSortAlgorithmProcess(EnumSortAlgorithm.MERGE_SORT)
                .setSearchAlgorithmProcess(EnumSearchAlgorithm.BINARY_SEARCH)
                .setWordProcessUsedTable(wordProcessUsedTable);
        return (TestAlgorithmResult) setResultService;
    }

}
