<%--
  Created by IntelliJ IDEA.
  User: Afran
  Date: 7/19/2025
  Time: 1:33 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>AXIS Bank Dashboard</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <style>
        :root {
            --primary-color: #3498db;
            --secondary-color: #540e0e;
            --success-color: #2ecc71;
            --info-color: #1abc9c;
            --warning-color: #f39c12;
            --danger-color: #e74c3c;
            --light-color: #ecf0f1;
            --dark-color: #34495e;
        }

        body {
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            background-color: #f5f5f5;
        }

        .sidebar {
            background-color: var(--secondary-color);
            color: white;
            height: 100vh;
            position: fixed;
            padding-top: 20px;
        }

        .sidebar .nav-link {
            color: rgba(255, 255, 255, 0.8);
            margin-bottom: 5px;
            border-radius: 5px;
            padding: 10px 15px;
        }

        .sidebar .nav-link:hover, .sidebar .nav-link.active {
            background-color: rgba(255, 255, 255, 0.1);
            color: white;
        }
        .axisBtn{
            background-color: #690000;
            color: white;
            padding: 10px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        .axisBtn:hover{
            background-color: #753636;
            color: white;
            padding: 10px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        .sidebar .nav-link i {
            margin-right: 10px;
        }

        .main-content {
            margin-left: 250px;
            padding: 20px;
        }

        .user-profile {
            display: flex;
            align-items: center;
        }

        .user-profile img {
            width: 40px;
            height: 40px;
            border-radius: 50%;
            margin-right: 10px;
        }

        .summary-card {
            border-radius: 10px;
            padding: 20px;
            color: white;
            margin-bottom: 20px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            transition: transform 0.3s;
        }

        .summary-card:hover {
            transform: translateY(-5px);
        }

        .summary-card i {
            font-size: 2.5rem;
            opacity: 0.8;
        }

        .card-customers {
            background-color: var(--primary-color);
        }

        .card-accounts {
            background-color: var(--success-color);
        }

        .card-transfers {
            background-color: var(--warning-color);
        }

        .card-transactions {
            background-color: var(--info-color);
        }

        .quick-action-card {
            border: none;
            border-radius: 10px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            transition: transform 0.3s;
            text-align: center;
            padding: 20px 10px;
            cursor: pointer;
        }

        .quick-action-card:hover {
            transform: translateY(-5px);
        }

        .quick-action-card i {
            font-size: 2rem;
            margin-bottom: 15px;
            color: var(--primary-color);
        }

        .activity-item {
            padding: 10px 0;
            border-bottom: 1px solid #eee;
        }

        .activity-item:last-child {
            border-bottom: none;
        }

        .activity-time {
            font-size: 0.8rem;
            color: #777;
        }

        .modal-header {
            background-color: var(--primary-color);
            color: white;
        }

        .table th {
            background-color: var(--secondary-color);
            color: white;
        }

        .status-active {
            color: var(--success-color);
            font-weight: bold;
        }

        .status-pending {
            color: var(--warning-color);
            font-weight: bold;
        }

        .status-inactive {
            color: var(--danger-color);
            font-weight: bold;
        }

        .action-btn {
            margin: 0 3px;
        }
    </style>
</head>
<body>
<div class="container-fluid">
    <div class="row">
        <!-- Sidebar -->
        <div class="col-md-2 sidebar d-none d-md-block">
            <div class="mb-4 text-center">
                <h4>AXIS Bank System</h4>
            </div>
            <ul class="nav flex-column">
                <li class="nav-item">
                    <a class="nav-link active" href="${pageContext.request.contextPath}/dashboard">
                        <i class="fas fa-tachometer-alt"></i> Dashboard
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/customerAccount">
                        <i class="fas fa-users"></i> Accounts Management
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/scheduleTransfer">
                        <i class="fas fa-exchange-alt"></i> Scheduled Transfers
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">
                        <i class="fas fa-chart-bar"></i> Reports
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">
                        <i class="fas fa-arrow-alt-circle-left"></i> Log Out
                    </a>
                </li>
            </ul>
        </div>

        <!-- Main Content -->
        <div class="col-md-10 ms-sm-auto main-content">
            <!-- Top Navigation -->
            <div class="mb-4 d-flex justify-content-between align-items-center">
                <h2>Dashboard</h2>
                <div class="user-profile">
                    <div>
                        <div class="fw-bold">John Doe</div>
                        <div class="text-muted small">Admin</div>
                    </div>
                </div>
            </div>

            <!-- Summary Cards -->
            <div class="mb-4 row">
                <div class="col-md-3">
                    <div class="summary-card card-customers">
                        <div class="d-flex justify-content-between">
                            <div>
                                <h5>Total Customers</h5>
                                <h2>1,248</h2>
                            </div>
                            <i class="fas fa-users"></i>
                        </div>
                        <div class="mt-2">
                            <span class="badge bg-light text-dark">+12 this week</span>
                        </div>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="summary-card card-accounts">
                        <div class="d-flex justify-content-between">
                            <div>
                                <h5>Active Accounts</h5>
                                <h2>2,567</h2>
                            </div>
                            <i class="fas fa-piggy-bank"></i>
                        </div>
                        <div class="mt-2">
                            <span class="badge bg-light text-dark">+24 this week</span>
                        </div>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="summary-card card-transfers">
                        <div class="d-flex justify-content-between">
                            <div>
                                <h5>Pending Transfers</h5>
                                <h2>34</h2>
                            </div>
                            <i class="fas fa-exchange-alt"></i>
                        </div>
                        <div class="mt-2">
                            <span class="badge bg-light text-dark">+5 today</span>
                        </div>
                    </div>
                </div>
                <div class="col-md-3">
                    <div class="summary-card card-transactions">
                        <div class="d-flex justify-content-between">
                            <div>
                                <h5>Today's Transactions</h5>
                                <h2>189</h2>
                            </div>
                            <i class="fas fa-hand-holding-usd"></i>
                        </div>
                        <div class="mt-2">
                            <span class="badge bg-light text-dark">$42,580 total</span>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Quick Actions and Recent Activity -->
            <div class="row">
                <!-- Quick Actions -->
                <div class="mb-4 ">
                    <div class="card">
                        <div class="bg-white card-header">
                            <h5 class="card-title">Quick Actions</h5>
                        </div>
                        <div class="card-body">
                            <div class="row">
                                <div class="mb-3 col-md-6">
                                    <div class="quick-action-card">
                                        <i class="fas fa-user-plus"></i>
                                        <h6>Create New Account</h6>
                                        <button class="mt-2 btn btn-sm axisBtn" data-bs-toggle="modal" data-bs-target="#newCustomerModal">Open</button>
                                    </div>
                                </div>
                                <div class="mb-3 col-md-6">
                                    <div class="quick-action-card">
                                        <i class="fas fa-exchange-alt"></i>
                                        <h6>Schedule Transfer</h6>
                                        <button class="mt-2 btn btn-sm axisBtn" data-bs-toggle="modal" data-bs-target="#scheduleTransferModal">Open</button>
                                    </div>
                                </div>
                                <div class="mb-3 col-md-6">
                                    <div class="quick-action-card">
                                        <i class="fas fa-file-alt"></i>
                                        <h6>Generate Report</h6>
                                        <button class="mt-2 btn btn-sm axisBtn">Generate</button>
                                    </div>
                                </div>
                                <div class="mb-3 col-md-6">
                                    <div class="quick-action-card">
                                        <i class="fas fa-calculator"></i>
                                        <h6>Calculate Interest</h6>
                                        <button class="mt-2 btn btn-sm axisBtn">Calculate</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>


            <!-- Customer Accounts Section -->
            <div class="mb-4 card">
                <div class="card-body">

                    <!-- Accounts Table -->
                    <div class="table-responsive">
                        <table class="table table-striped table-hover">
                            <thead>
                            <tr>
                                <th>Customer</th>
                                <th>Account Number</th>
                                <th>Account Type</th>
                                <th>Balance</th>
                                <th>Status</th>
                                <th>Last Activity</th>
                                <th>Actions</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var = "account" items="${userAccounts}">
                                <tr>
                                    <td>${account.firstName} ${account.lastName}</td>
                                    <td>${account.accountNumber}</td>
                                    <td>${account.accountType.type}</td>
                                    <td>$${account.balance}</td>
                                    <td><span class="status-active">${account.status}</span></td>
                                    <td>
                                        <fmt:formatDate value="${account.createdDate}" pattern="yyyy-MM-dd"/>
                                    </td>
                                    <td>
                                        <button class="btn btn-sm btn-outline-primary action-btn"><i class="fas fa-eye"></i></button>
                                        <button class="btn btn-sm btn-outline-success action-btn"><i class="fas fa-edit"></i></button>
                                        <button class="btn btn-sm btn-outline-danger action-btn"><i class="fas fa-trash"></i></button>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>


        </div>
    </div>

</div>



    <!-- Bootstrap Bundle with Popper -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
