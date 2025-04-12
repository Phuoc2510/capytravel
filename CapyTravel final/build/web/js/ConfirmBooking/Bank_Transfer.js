
function updatePaymentFields() {
    const bankSelect = document.getElementById('bank');
    const vietcombankFields = document.getElementById('vietcombank-fields');
    const otherBanksFields = document.getElementById('other-banks-fields');

    if (bankSelect.value === 'Vietcombank') {
        vietcombankFields.style.display = 'block';
        otherBanksFields.style.display = 'none';
    } else {
        vietcombankFields.style.display = 'none';
        otherBanksFields.style.display = 'block';
    }
}

function handlePayment() {
//    alert("Thank you for choosing our services. Your flight itinerary will be sent to your email shortly.");
//    window.location.href = 'index.html'; // Replace 'index.html' with your main page URL
//    
    const selectedBank = document.getElementById('VCB').value;

    // Kiểm tra nếu người dùng chưa chọn phương thức thanh toán
    if (selectedBank === "Select option") {
        alert("Please select a payment method.");
        event.preventDefault(); // Ngăn chặn việc gửi biểu mẫu
    } else {
        alert("Thank you for choosing our services. Your flight itinerary will be sent to your email shortly.");
        window.location.href = 'index.html'; // Thay 'index.html' bằng URL trang chính của bạn
    }
}