package com.ahmeteminsaglik.AlgorithmTestServer.business;

import org.ahmeteminsaglik.MemoryUsage;
import org.ahmeteminsaglik.Stopwatch;
import org.ahmeteminsaglik.TestAlgorithmResult;
import org.ahmeteminsaglik.abstracts.set.api.SetTestResultService;
import org.ahmeteminsaglik.entity.WordProcessUsedTable;
import org.ahmeteminsaglik.enums.EnumDataStructor;
import org.ahmeteminsaglik.enums.EnumSearchAlgorithm;
import org.ahmeteminsaglik.enums.EnumSortAlgorithm;
import org.ahmeteminsaglik.enums.EnumWordTable;

public class TestAlgorithmFactory {
    public TestAlgorithmResult build() {

        TestAlgorithmResult setResultService = new TestAlgorithmResult();

        WordProcessUsedTable wordProcessUsedTable = new WordProcessUsedTable(EnumWordTable.WORD_50_000, EnumWordTable.WORD_15_000);

        setResultService
//                    .setDataStructorProcess(EnumDataStructor.HASHMAP)
//                    .setDataStructorProcess(EnumDataStructor.SEARCHNODE_V1)
                .setDataStructorProcess(EnumDataStructor.ARRAYLIST)
//                    .setSortAlgorithmProcess(EnumSortAlgorithm.TIM_SORT)
                .setSortAlgorithmProcess(EnumSortAlgorithm.MERGE_SORT)
//                    .setSearchAlgorithmProcess(EnumSearchAlgorithm.HASHMAP)
//                    .setSearchAlgorithmProcess(EnumSearchAlgorithm.SEARCH_NODE)
                .setSearchAlgorithmProcess(EnumSearchAlgorithm.BINARY_SEARCH)
                .setWordProcessUsedTable(wordProcessUsedTable)
                .setComplexityConseptDataStructor(getFakeStopwatch(),getFakeMemoryUsage())
                .setComplexityConseptSortAlgorithm(getFakeStopwatch(),getFakeMemoryUsage())
                .setComplexityConseptSearchAlgorithm(getFakeStopwatch(),getFakeMemoryUsage());
        return setResultService;

    }

    private static Stopwatch getFakeStopwatch() {
        Stopwatch stopwatch = new Stopwatch();
        stopwatch.startTime();
        stopwatch.stopTime();
        return stopwatch;
    }

    private static MemoryUsage getFakeMemoryUsage() {
        MemoryUsage memoryUsage = new MemoryUsage();
        memoryUsage.calculateMemoryBeforeProcess();
        memoryUsage.calculateMemoryAfterProcess();
        return memoryUsage;
    }
}
