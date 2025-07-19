<%--
  Created by IntelliJ IDEA.
  User: Afran
  Date: 7/19/2025
  Time: 2:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>AXIS Bank | Scheduled Transfers</title>
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

        .modal-header {
            background-color: var(--primary-color);
            color: white;
        }

        .table th {
            background-color: var(--secondary-color);
            color: white;
        }

        .action-btn {
            margin: 0 3px;
        }

        .search-card {
            background-color: white;
            border-radius: 10px;
            padding: 20px;
            margin-bottom: 20px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
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
                    <a class="nav-link" href="${pageContext.request.contextPath}/admin">
                        <i class="fas fa-tachometer-alt"></i> Dashboard
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/admin/customerAccount.jsp"">
                        <i class="fas fa-users"></i> Customer Accounts
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="${pageContext.request.contextPath}/admin/scheduledTransfers.jsp">
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
                <h2>Scheduled Transfers</h2>
                <div class="user-profile">
                    <div>
                        <div class="fw-bold">John Doe</div>
                        <div class="text-muted small">Admin</div>
                    </div>
                </div>
            </div>

            <!-- Scheduled Transfers Section -->
            <div class="card">
                <div class="bg-white card-header d-flex justify-content-between align-items-center">
                    <h5 class="card-title">Scheduled Transfers Management</h5>
                    <button class="btn axisBtn" data-bs-toggle="modal" data-bs-target="#scheduleTransferModal">
                        <i class="fas fa-plus me-1"></i> New Scheduled Transfer
                    </button>
                </div>
                <div class="card-body">
                    <!-- Search Form -->
                    <div class="mb-4 search-card">
                        <div class="row">
                            <div class="col-md-4">
                                <label for="fromAccountSearch" class="form-label">From Account</label>
                                <select class="form-select" id="fromAccountSearch">
                                    <option selected>All Accounts</option>
                                    <option>ACC-10025 - John Smith</option>
                                    <option>ACC-10038 - Emily Johnson</option>
                                    <option>ACC-10042 - Michael Brown</option>
                                    <option>ACC-10056 - Sarah Williams</option>
                                </select>
                            </div>
                            <div class="col-md-4">
                                <label for="statusSearch" class="form-label">Status</label>
                                <select class="form-select" id="statusSearch">
                                    <option selected>All Status</option>
                                    <option>Pending</option>
                                    <option>Completed</option>
                                    <option>Failed</option>
                                    <option>Cancelled</option>
                                </select>
                            </div>
                            <div class="col-md-4">
                                <label for="dateRange" class="form-label">Date Range</label>
                                <input type="text" class="form-control" id="dateRange" placeholder="Select date range">
                            </div>
                        </div>
                        <div class="mt-3 row">
                            <div class="col-md-12 text-end">
                                <button class="btn axisBtn me-2">Search</button>
                                <button class="btn btn-outline-secondary">Reset</button>
                            </div>
                        </div>
                    </div>

                    <!-- Transfers Table -->
                    <div class="table-responsive">
                        <table class="table table-striped table-hover">
                            <thead>
                            <tr>
                                <th>Transfer ID</th>
                                <th>From Account</th>
                                <th>To Account</th>
                                <th>Amount</th>
                                <th>Date & Time</th>
                                <th>Frequency</th>
                                <th>Status</th>
                                <th>Actions</th>
                            </tr>
                            </thead>
                            <tbody>
                            <tr>
                                <td>TR-2023-001</td>
                                <td>ACC-10025 (John Smith)</td>
                                <td>ACC-10038 (Emily Johnson)</td>
                                <td>$500.00</td>
                                <td>Tomorrow, 9:00 AM</td>
                                <td>One-time</td>
                                <td><span class="badge bg-warning text-dark">Pending</span></td>
                                <td>
                                    <button class="btn btn-sm btn-outline-success action-btn"><i class="fas fa-edit"></i></button>
                                    <button class="btn btn-sm btn-outline-danger action-btn"><i class="fas fa-trash"></i></button>
                                </td>
                            </tr>
                            <tr>
                                <td>TR-2023-002</td>
                                <td>ACC-10056 (Sarah Williams)</td>
                                <td>ACC-10042 (Michael Brown)</td>
                                <td>$1,200.00</td>
                                <td>Jul 25, 2023, 10:00 AM</td>
                                <td>Monthly</td>
                                <td><span class="badge bg-warning text-dark">Pending</span></td>
                                <td>
                                    <button class="btn btn-sm btn-outline-success action-btn"><i class="fas fa-edit"></i></button>
                                    <button class="btn btn-sm btn-outline-danger action-btn"><i class="fas fa-trash"></i></button>
                                </td>
                            </tr>
                            <tr>
                                <td>TR-2023-003</td>
                                <td>ACC-10038 (Emily Johnson)</td>
                                <td>External: 123456789</td>
                                <td>$300.00</td>
                                <td>Aug 1, 2023, 2:00 PM</td>
                                <td>Weekly</td>
                                <td><span class="badge bg-warning text-dark">Pending</span></td>
                                <td>
                                    <button class="btn btn-sm btn-outline-success action-btn"><i class="fas fa-edit"></i></button>
                                    <button class="btn btn-sm btn-outline-danger action-btn"><i class="fas fa-trash"></i></button>
                                </td>
                            </tr>
                            <tr>
                                <td>TR-2023-004</td>
                                <td>ACC-10025 (John Smith)</td>
                                <td>ACC-10056 (Sarah Williams)</td>
                                <td>$750.00</td>
                                <td>Jul 20, 2023, 11:00 AM</td>
                                <td>One-time</td>
                                <td><span class="badge bg-success">Completed</span></td>
                                <td>
                                    <button class="btn btn-sm btn-outline-primary action-btn"><i class="fas fa-eye"></i></button>
                                </td>
                            </tr>
                            <tr>
                                <td>TR-2023-005</td>
                                <td>ACC-10042 (Michael Brown)</td>
                                <td>External: 987654321</td>
                                <td>$150.00</td>
                                <td>Jul 18, 2023, 3:30 PM</td>
                                <td>Weekly</td>
                                <td><span class="badge bg-danger">Failed</span></td>
                                <td>
                                    <button class="btn btn-sm btn-outline-primary action-btn"><i class="fas fa-eye"></i></button>
                                    <button class="btn btn-sm btn-outline-success action-btn"><i class="fas fa-redo"></i></button>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Schedule Transfer Modal -->
<div class="modal fade" id="scheduleTransferModal" tabindex="-1" aria-labelledby="scheduleTransferModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="scheduleTransferModalLabel">Schedule New Transfer</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form>
                    <div class="mb-3">
                        <label for="fromAccount" class="form-label">From Account</label>
                        <select class="form-select" id="fromAccount" required>
                            <option selected>Select Account</option>
                            <option>ACC-10025 - John Smith ($5,420.50)</option>
                            <option>ACC-10038 - Emily Johnson ($3,210.00)</option>
                            <option>ACC-10042 - Michael Brown ($1,200.00)</option>
                            <option>ACC-10056 - Sarah Williams ($12,780.25)</option>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label for="toAccount" class="form-label">To Account</label>
                        <select class="form-select" id="toAccount" required>
                            <option selected>Select Account</option>
                            <option>ACC-10025 - John Smith ($5,420.50)</option>
                            <option>ACC-10038 - Emily Johnson ($3,210.00)</option>
                            <option>ACC-10042 - Michael Brown ($1,200.00)</option>
                            <option>ACC-10056 - Sarah Williams ($12,780.25)</option>
                            <option>External Transfer</option>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label for="amount" class="form-label">Amount</label>
                        <div class="input-group">
                            <span class="input-group-text">$</span>
                            <input type="number" class="form-control" id="amount" value="0.00" step="0.01" required>
                        </div>
                    </div>
                    <div class="mb-3 row">
                        <div class="col-md-6">
                            <label for="transferDate" class="form-label">Transfer Date</label>
                            <input type="date" class="form-control" id="transferDate" required>
                        </div>
                        <div class="col-md-6">
                            <label for="transferTime" class="form-label">Transfer Time</label>
                            <input type="time" class="form-control" id="transferTime" required>
                        </div>
                    </div>
                    <div class="mb-3">
                        <label for="frequency" class="form-label">Frequency</label>
                        <select class="form-select" id="frequency">
                            <option selected>One-time</option>
                            <option>Daily</option>
                            <option>Weekly</option>
                            <option>Monthly</option>
                            <option>Quarterly</option>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label for="description" class="form-label">Description</label>
                        <textarea class="form-control" id="description" rows="2"></textarea>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                <button type="button" class="btn axisBtn">Schedule Transfer</button>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
