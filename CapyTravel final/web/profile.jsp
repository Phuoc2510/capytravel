<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Capybare - Profile</title>
        <link rel="stylesheet" href="style.css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/css/bootstrap.min.css" rel="stylesheet">
    </head>

    <body>

        <form action="CapyTravelController" method="POST">


            <div class="container light-style flex-grow-1 container-p-y">
                <h4 class="font-weight-bold py-3 mb-4">Account settings</h4>

                <div class="card overflow-hidden">
                    <div class="row no-gutters row-bordered row-border-light">
                        <div class="col-md-3 pt-0">
                            <div class="list-group list-group-flush account-settings-links">
                                <a class="list-group-item list-group-item-action active" data-toggle="list" href="#account-general">General</a>
                                <a class="list-group-item list-group-item-action" data-toggle="list" href="#account-change-password">Change password</a>
                            </div>
                        </div>

                        <div class="col-md-9">
                            <div class="tab-content">
                                <!-- Tab: General -->
                                <div class="tab-pane fade active show" id="account-general">

                                    <hr class="border-light m-0">

                                    <!-- Update Form Fields -->
                                    <div class="card-body">
                                        <input type="hidden" name="id" value="${requestScope.SEARCH_USER.userID}">

                                        <div class="card-body media align-items-center profile_avatar">

                                            <img src="<%= request.getContextPath()%>/imgs/Avatar/${requestScope.SEARCH_USER.avatar}" alt="" style="width: 300px; height: auto;" 
                                                 id="avatarPreview" class="avatar-image">

                                            <div class="media-body ml-4">
                                                <label class="btn btn-outline-primary profile_avatar">
                                                    Upload photo

                                                    <input type="file" class="account-settings-fileinput" name="avatar" value="${requestScope.SEARCH_USER.avatar}" accept="image/jpeg, image/png, image/gif" onchange="previewImage(event)">
                                                </label>

                                                <button type="button" class="btn btn-default md-btn-flat" onclick="resetInput()">Reset</button>
                                                <div class="text-light small mt-1">Allowed JPG, GIF or PNG. Max size of 800K</div>
                                            </div>

                                        </div>


                                        <div class="form-group">
                                            <label class="form-label">First Name</label>
                                            <input type="text" class="form-control" name="firstname" value="${requestScope.SEARCH_USER.firstName}" required>
                                        </div>
                                        <div class="form-group">
                                            <label class="form-label">Last Name</label>
                                            <input type="text" class="form-control" name="lastname" value="${requestScope.SEARCH_USER.lastName}" required>
                                        </div>

                                        <div class="form-group">
                                            <label class="form-label">Username</label>
                                            <input type="text" class="form-control" name="username" value="${requestScope.SEARCH_USER.userName}" required>
                                        </div>

                                        <div class="form-group">
                                            <label class="form-label">Email</label>
                                            <input type="email" class="form-control" name="email" value="${requestScope.SEARCH_USER.email}" required>
                                        </div>

                                        <div class="form-group">
                                            <label class="form-label">Phone Number</label>
                                            <input type="text" class="form-control" name="phonenumber" value="${requestScope.SEARCH_USER.phoneNumber}" required >
                                        </div>

                                        <div class="form-group">
                                            <label class="form-label">Gender</label>
                                            <select class="custom-select" name="gender">
                                                <option value="Male" ${requestScope.SEARCH_USER.gender == 'Male' ? 'selected' : ''}>Male</option>
                                                <option value="Female" ${requestScope.SEARCH_USER.gender == 'Female' ? 'selected' : ''}>Female</option>
                                            </select>
                                        </div>

                                        <div class="form-group">
                                            <label class="form-label">Date of Birth</label>
                                            <input type="date" class="form-control" name="dateOfBirth" value="${requestScope.SEARCH_USER.dateOfBirth}" required>
                                        </div>

                                        <div class="form-group">
                                            <label class="form-label">Identification Number</label>
                                            <input type="text" class="form-control" name="identificationnumber" value="${requestScope.SEARCH_USER.identificationNumber}" required>
                                        </div>
                                    </div>
                                </div>

                                <!-- Tab: Change Password -->
                                <div class="tab-pane fade" id="account-change-password">
                                    <div class="card-body pb-2">
                                        <!-- Form fields for password change -->
                                        <div class="form-group">
                                            <label class="form-label">Current Password</label>
                                            <input type="password" class="form-control" name="currentPassword">
                                        </div>
                                        <div class="form-group">
                                            <label class="form-label">New Password</label>
                                            <input type="password" class="form-control" name="newPassword">
                                        </div>
                                        <div class="form-group">
                                            <label class="form-label">Repeat New Password</label>
                                            <input type="password" class="form-control" name="repeatNewPassword">
                                        </div>
                                    </div>
                                </div>


                            </div>
                        </div>
                    </div>
                </div>

                <div class="text-right mt-3">
                    <button type="submit" name="action" value="userSaveProfile" class="btn btn-primary">Save Changes</button>
                    <button type="submit" name="action" value="userCancelProfile" class="btn btn-default">Cancel</button>
                </div>
            </div>
        </form>

        <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.0/dist/js/bootstrap.bundle.min.js"></script>
    </body>



</html>
