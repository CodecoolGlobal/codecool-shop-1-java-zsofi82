const quantity = document.querySelectorAll('.quantity');

function increase(clickEvent){
    let counter = parseInt(clickEvent.currentTarget.nextSibling.innerText);
    counter += 1;
    clickEvent.currentTarget.nextSibling.innerText = counter;
}

function decrease(clickEvent){
    let counter = parseInt(clickEvent.currentTarget.previousSibling.innerText);
    if(counter !== 0) {
        counter -= 1;
    }else{
        counter = 0;
    }
    clickEvent.currentTarget.previousSibling.innerText = counter;
}

function createButtons(){
    quantity.forEach(element => {
        const plusBtn = document.createElement("button");
        const minusBtn = document.createElement("button");
        const counterSpan = document.createElement("span");
        plusBtn.innerText = "+";
        minusBtn.innerText = "-";
        counterSpan.innerText = 0;

        plusBtn.dataset.spanId = element.dataset.spanId;
        minusBtn.dataset.spanId = element.dataset.spanId;
        counterSpan.dataset.spanId = element.dataset.spanId;

        plusBtn.addEventListener('click', increase);
        minusBtn.addEventListener('click', decrease);
        element.append(plusBtn, counterSpan, minusBtn);
    })
}


data.orderitems.forEach(element => {

        const heroname = data.heroes[element.heroeid].name;
        const productname = data.productcategories[element.productid].name;
        const quantity = element.quantity;
    });

function init(){
    createButtons();
}

init();
