const categoryList = document.querySelectorAll('.category-list');
const container = document.querySelector('#container');
const addButton = document.querySelectorAll('#addButton');
const cartButton = document.querySelector('#cartButton');

async function addToCart(clickEvent) {
    const heroId = clickEvent.currentTarget.dataset.eventId;
    const productSelectorElement = document.querySelector(`select[data-event-id="${heroId}"]`);
    await apiPut('/api/order', productSelectorElement.value, 1, heroId);
}

async function apiPut(url, productId, quantity, heroId) {
    await fetch(url, {
        method: "PUT",
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(
            {
                productID: productId,
                quantity: quantity,
                heroID: heroId
            }
        )
    })
}

async function apiGet(url) {
    let response = await fetch(url);
    if (response.ok) {
        return response.json();
    }
}

async function createTBody() {
    container.innerHTML = "";
    let data = await apiGet('/api/order');

    data.orderitems.forEach(element => {
        const orderId = `${element.heroID};${element.productID}`;

        const tr = document.createElement('tr');
        tr.dataset.orderId = orderId;
        const heroNameTd = document.createElement('td');
        const productNameTd = document.createElement('td');
        const quantityTd = document.createElement('td');
        const plusBtn = document.createElement("button");
        const minusBtn = document.createElement("button");
        let counterSpan = document.createElement("span");

        const heroName = findItem(data.heroes, element.heroID).name;
        const productName = findItem(data.productcategories, element.productID).name;
        const quantity = element.quantity;

        plusBtn.dataset.orderId = orderId;
        minusBtn.dataset.orderId = orderId;
        counterSpan.dataset.orderId = orderId;
        plusBtn.classList.add('btn', 'btn-primary');
        minusBtn.classList.add('btn', 'btn-primary');

        heroNameTd.innerText = heroName;
        productNameTd.innerText = productName;
        plusBtn.innerText = "+";
        minusBtn.innerText = "-";
        counterSpan.innerText = quantity;

        plusBtn.addEventListener('click', increase);
        minusBtn.addEventListener('click', decrease);

        quantityTd.append(plusBtn, counterSpan, minusBtn);
        tr.append(heroNameTd, productNameTd, quantityTd);
        container.appendChild(tr);
    });
}

function findItem(collection, itemId) {
    return collection.filter(item => itemId === item.id)[0];
}

function parseOrderId(orderId) {
    return orderId.split(';');
}


async function updateOrderItem(orderId, counter) {
    let heroId, productId;
    [heroId, productId] = parseOrderId(orderId);
    await apiPut('/api/order', productId, counter, heroId);
}

async function increase(clickEvent) {
    const orderId = clickEvent.currentTarget.dataset.orderId;
    const counterElement = document.querySelector(`span[data-order-id="${orderId}"]`);
    const counter = parseInt(counterElement.innerText) + 1;
    counterElement.innerText = counter;

    await updateOrderItem(orderId, counter);
}

async function decrease(clickEvent) {
    const orderId = clickEvent.currentTarget.dataset.orderId;
    const counterElement = document.querySelector(`span[data-order-id="${orderId}"]`);
    const counter = parseInt(counterElement.innerText) - 1;
    if (counter !== 0) {
        counterElement.innerText = counter;
    } else {
        document.querySelector(`tr[data-order-id="${orderId}"]`)
            .remove();
    }

    await updateOrderItem(orderId, counter);
}

function init() {
    addButton.forEach(element => {
        element.addEventListener('click', addToCart);
    });

    cartButton.addEventListener('click', createTBody);
}

init();