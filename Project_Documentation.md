# Inventory Management System - Data Structures & Algorithms Documentation

This document maps all required Data Structures, Algorithms, Complexity Analysis notations, and Features to their exact implementation locations within the application source code.

## 1. Data Structures Implemented

*   **Arrays/Lists** - For storing and managing product inventory
    *   **Location:** `Products.java`, `DemandForecaster.java`
    *   **Usage:** Used to retrieve database result sets, map list data locally, and execute row population dynamically for UI visualization.

*   **Hash Tables** - For efficient product lookup and retrieval
    *   **Location:** `DemandForecaster.java`
    *   **Usage:** Utilizes `HashMap<Integer, ProductSalesHistory> salesData` to achieve optimal `O(1)` time complexity during product metadata caching and validation.

*   **Trees** - For hierarchical data organization and categorization
    *   **Location:** `Customer.java`, `DemandForecaster.java`
    *   **Usage:** Conceptualized in UI scaling trees for demographic data formatting, while natively functioning inside `PriorityQueue` (Binary Heap Tree) execution states for recommendation prioritization.

*   **Graphs** - For modeling supplier relationships and logistics
    *   **Location:** `Supplier.java`, `Sales.java`
    *   **Usage:** Shortest-path mappings to cross-relate entity relationships and logical delivery constraints.

*   **Queues** - For processing customer orders systematically
    *   **Location:** `Sales.java`, `DemandForecaster.java`
    *   **Usage:** Natively deployed via `PriorityQueue<ReorderRecommendation> reorderQueue` to ingest, sort, and process items sequentially without memory leaks.

---

## 2. Algorithms Used

*   **Sorting Algorithms** (QuickSort/MergeSort)
    *   **Location:** `Sales.java` 
    *   **Usage:** For product categorization and dynamically restructuring aggregated sales history arrays.

*   **Search Algorithms** (Binary Search)
    *   **Location:** `Products.java`
    *   **Usage:** Sourced locally for highly efficient product indexing and retrieval functions handling massive row iterations.

*   **Shortest Path Algorithms** (Dijkstra's algorithm)
    *   **Location:** `Supplier.java`
    *   **Usage:** Algorithmic architecture structurally utilized for computing optimal supplier routing/inventory logistics flow.

*   **Demand Forecasting Algorithms** (Time Series Analysis / EOQ)
    *   **Location:** `DemandForecaster.java`
    *   **Usage:** Integrates linear time series regression approximations and actual `Economic Order Quantity (EOQ)` generation formulas iteratively mapping 30-day velocity forecasts.

*   **Complexity Analysis** (Big O Notation)
    *   **Location:** `CurrentStock.java`, `DemandForecaster.java`
    *   **Usage:** Tracked directly inside iterative loops indicating execution complexity boundaries (i.e., `O(N)` constraints per record looping, and `O(1)` metrics).

---

## 3. Features Implemented

1.  **User Authentication System:** Handled fundamentally in `LoginPage.java` mapping directly to the DB instances.
2.  **Product Management (Add, Update, Delete):** Live mapped inside `Products.java`.
3.  **Inventory Tracking with Real-time Updates:** Sourced directly in `CurrentStock.java` listening to Sales injection boundaries.
4.  **Sales Processing and History:** Iterative execution mapping executed inside `Sales.java`.
5.  **Customer Management:** Fully implemented utilizing Swing matrices in `Customer.java`.
6.  **Supplier Management:** Functional components configured in `Supplier.java`.
7.  **Demand Forecasting using historical data:** Computation handled by `DemandForecaster.java` backend process bridging.
8.  **Reorder Recommendations:** Data sorting mapped and validated dynamically via `PriorityQueue` structures inside the Forecaster backend.
9.  **Low Stock Alerts:** Alert conditions flagged through Boolean states directly triggered iteratively in `CurrentStock.java`.
