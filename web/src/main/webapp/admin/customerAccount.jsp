<%--
  Created by IntelliJ IDEA.
  User: Afran
  Date: 7/19/2025
  Time: 1:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>AXIS Bank | Customer Accounts</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
    <style>
        :root {
            --primary-color: #a42929;
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
                    <a class="nav-link" href="${pageContext.request.contextPath}/admin">
                        <i class="fas fa-tachometer-alt"></i> Dashboard
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" href="${pageContext.request.contextPath}/admin/customerAccount.jsp">
                        <i class="fas fa-users"></i> Accounts Management
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="${pageContext.request.contextPath}/admin/scheduledTransfers.jsp">
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
                <h2>Customer Accounts</h2>
                <div class="user-profile">
                    <div>
                        <div class="fw-bold">John Doe</div>
                        <div class="text-muted small">Admin</div>
                    </div>
                </div>
            </div>

            <!-- Customer Accounts Section -->
            <div class="mb-4 card">
                <div class="bg-white card-header d-flex justify-content-between align-items-center">
                    <h5 class="card-title">Customer Accounts Management</h5>
                    <button class="btn axisBtn" data-bs-toggle="modal" data-bs-target="#newCustomerModal">
                        <i class="fas fa-user-plus me-1"></i> Add New Customer
                    </button>
                </div>
                <div class="card-body">
                    <!-- Search Form -->
                    <div class="mb-3 row">
                        <div class="col-md-4">
                            <input type="text" class="form-control" placeholder="Customer Name">
                        </div>
                        <div class="col-md-3">
                            <input type="text" class="form-control" placeholder="Account Number">
                        </div>
                        <div class="col-md-3">
                            <select class="form-select">
                                <option selected>All Status</option>
                                <option>Active</option>
                                <option>Pending</option>
                                <option>Inactive</option>
                            </select>
                        </div>
                        <div class="col-md-2">
                            <button class="btn axisBtn w-100">Search</button>
                        </div>
                    </div>

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
                            <tr>
                                <td>John Smith</td>
                                <td>ACC-10025</td>
                                <td>Savings</td>
                                <td>$5,420.50</td>
                                <td><span class="status-active">Active</span></td>
                                <td>Today, 10:15 AM</td>
                                <td>
                                    <button class="btn btn-sm btn-outline-primary action-btn"><i class="fas fa-eye"></i></button>
                                    <button class="btn btn-sm btn-outline-success action-btn"><i class="fas fa-edit"></i></button>
                                    <button class="btn btn-sm btn-outline-danger action-btn"><i class="fas fa-trash"></i></button>
                                </td>
                            </tr>
                            <tr>
                                <td>Emily Johnson</td>
                                <td>ACC-10038</td>
                                <td>Checking</td>
                                <td>$3,210.00</td>
                                <td><span class="status-active">Active</span></td>
                                <td>Today, 9:30 AM</td>
                                <td>
                                    <button class="btn btn-sm btn-outline-primary action-btn"><i class="fas fa-eye"></i></button>
                                    <button class="btn btn-sm btn-outline-success action-btn"><i class="fas fa-edit"></i></button>
                                    <button class="btn btn-sm btn-outline-danger action-btn"><i class="fas fa-trash"></i></button>
                                </td>
                            </tr>
                            <tr>
                                <td>Michael Brown</td>
                                <td>ACC-10042</td>
                                <td>Savings</td>
                                <td>$1,200.00</td>
                                <td><span class="status-pending">Pending</span></td>
                                <td>Yesterday, 2:45 PM</td>
                                <td>
                                    <button class="btn btn-sm btn-outline-primary action-btn"><i class="fas fa-eye"></i></button>
                                    <button class="btn btn-sm btn-outline-success action-btn"><i class="fas fa-edit"></i></button>
                                    <button class="btn btn-sm btn-outline-danger action-btn"><i class="fas fa-trash"></i></button>
                                </td>
                            </tr>
                            <tr>
                                <td>Sarah Williams</td>
                                <td>ACC-10056</td>
                                <td>Business</td>
                                <td>$12,780.25</td>
                                <td><span class="status-active">Active</span></td>
                                <td>Yesterday, 11:20 AM</td>
                                <td>
                                    <button class="btn btn-sm btn-outline-primary action-btn"><i class="fas fa-eye"></i></button>
                                    <button class="btn btn-sm btn-outline-success action-btn"><i class="fas fa-edit"></i></button>
                                    <button class="btn btn-sm btn-outline-danger action-btn"><i class="fas fa-trash"></i></button>
                                </td>
                            </tr>
                            <tr>
                                <td>David Miller</td>
                                <td>ACC-10061</td>
                                <td>Checking</td>
                                <td>$890.50</td>
                                <td><span class="status-inactive">Inactive</span></td>
                                <td>3 days ago</td>
                                <td>
                                    <button class="btn btn-sm btn-outline-primary action-btn"><i class="fas fa-eye"></i></button>
                                    <button class="btn btn-sm btn-outline-success action-btn"><i class="fas fa-edit"></i></button>
                                    <button class="btn btn-sm btn-outline-danger action-btn"><i class="fas fa-trash"></i></button>
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

<!-- Add New Customer Modal -->
<div class="modal fade" id="newCustomerModal" tabindex="-1" aria-labelledby="newCustomerModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="newCustomerModalLabel">Add New Customer</h5>
                <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
            </div>
            <div class="modal-body">
                <form action="${pageContext.request.contextPath}/addAccount" method="post">
                    <div class="mb-3 row">
                        <div class="col-md-6">
                            <label for="firstName" class="form-label">First Name</label>
                            <input type="text" class="form-control" id="firstName" name="firstName" required>
                        </div>
                        <div class="col-md-6">
                            <label for="lastName" class="form-label">Last Name</label>
                            <input type="text" class="form-control" id="lastName" name="lastName" required>
                        </div>
                    </div>
                    <div class="mb-3 row">
                        <div class="col-md-6">
                            <label for="email" class="form-label">Email</label>
                            <input type="email" class="form-control" id="email" name="email" required>
                        </div>
                        <div class="col-md-6">
                            <label for="phone" class="form-label">Phone</label>
                            <input type="tel" class="form-control" id="phone" name="phone" required>
                        </div>
                    </div>
                    <div class="mb-3">
                        <label for="address" class="form-label">Address</label>
                        <textarea class="form-control" id="address" name="address" rows="2"></textarea>
                    </div>
                    <div class="mb-3 row">
                        <div class="col-md-6">
                            <label for="dob" class="form-label">Date of Birth</label>
                            <input type="date" class="form-control" id="dob" name="dob">
                        </div>
                        <div class="col-md-6">
                            <label for="accountType" class="form-label">Account Type</label>
                            <select class="form-select" id="accountType" name="accountType">
                                <option selected>Select Account Type</option>
                                <option>Savings</option>
                                <option>Checking</option>
                                <option>Business</option>
                                <option>Student</option>
                            </select>
                        </div>
                    </div>
                    <div class="mb-3">
                        <label for="initialDeposit" class="form-label">Initial Deposit</label>
                        <div class="input-group">
                            <span class="input-group-text">$</span>
                            <input type="number" class="form-control" id="initialDeposit" value="0.00" step="0.01">
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                        <button type="submit" class="btn axisBtn">Create Account</button>
                    </div>

            </form>
            </div>
        </div>
    </div>
</div>

<!-- Bootstrap Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>