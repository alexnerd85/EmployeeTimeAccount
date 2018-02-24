<%-- 
    Document   : dashboard
    Created on : 18.02.2018, 16:37:49
    Author     : Aleksey
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<script type="text/javascript">
    var ctx = document.getElementById("myChart");
    var myChart = new Chart(ctx, {
        type: 'bar',
        data: {
            labels: ["Март", "Апрель", "Май", "Июнь", "Август", "Сентябрь"],
            datasets: [{
                    label: 'Количество отсутсвий',
                    data: [12, 19, 3, 5, 2, 3],
                    backgroundColor: [
                        'rgba(255, 99, 132, 0.2)',
                        'rgba(54, 162, 235, 0.2)',
                        'rgba(255, 206, 86, 0.2)',
                        'rgba(75, 192, 192, 0.2)',
                        'rgba(153, 102, 255, 0.2)',
                        'rgba(255, 159, 64, 0.2)'
                    ],
                    borderColor: [
                        'rgba(255,99,132,1)',
                        'rgba(54, 162, 235, 1)',
                        'rgba(255, 206, 86, 1)',
                        'rgba(75, 192, 192, 1)',
                        'rgba(153, 102, 255, 1)',
                        'rgba(255, 159, 64, 1)'
                    ],
                    borderWidth: 1
                }]
        },
        options: {
            scales: {
                yAxes: [{
                        ticks: {
                            beginAtZero: true
                        }
                    }]
            }
        }
    });
</script>

<div class="ui equal height grid">
    <div class="equal height row">
        <div class="twelve wide column">
            <div class="ui raised segments">
                <div class="ui segment">
                    <h4 class="ui header">
                        <i class="area chart icon"></i>
                        <div class="content">График отсутствий</div>
                        </h2>
                </div>
                <canvas id="myChart" width="400" height="135"></canvas>
            </div>
        </div>
        <div class="four wide column">
            <div class="ui raised segments">
                <div class="ui segment">
                    <h4 class="ui header">
                        <i class="checked calendar icon"></i>
                        <div class="content">Ближайшие отсутствия</div>
                        </h2>
                </div>
                <div class="ui segments">
                    <div class="ui segment">
                        <p>Тестовое отсутствие</p>
                    </div>
                    <div class="ui segment">
                        <p>Тестовое отсутствие</p>
                    </div>
                    <div class="ui segment">
                        <p>Тестовое отсутствие</p>
                    </div>
                    <div class="ui segment">
                        <p>Тестовое отсутствие</p>
                    </div>
                    <div class="ui segment">
                        <p>Тестовое отсутствие</p>
                    </div>                        
                </div>
            </div>
        </div>
    </div>
    <div class="row">        
        <div class="five wide column">
            <div class="ui raised segments">
                <div class="ui segment">
                    <h4 class="ui header">
                        <i class="checked calendar icon"></i>
                        <div class="content">Дни рождения</div>
                        </h2>
                </div>
                <div class="ui segments">
                    <div class="ui segment">
                        <p>День рождения</p>
                    </div>
                    <div class="ui segment">
                        <p>День рождения</p>
                    </div>
                    <div class="ui segment">
                        <p>День рождения</p>
                    </div>
                    <div class="ui segment">
                        <p>День рождения</p>
                    </div>
                    <div class="ui segment">
                        <p>День рождения</p>
                    </div>                        
                </div>
            </div>
        </div>
        <div class="five wide column">
            <div class="ui raised segments">
                <div class="ui segment">
                    <h4 class="ui header">
                        <i class="checked calendar icon"></i>
                        <div class="content">Праздники</div>
                        </h2>
                </div>
                <div class="ui segments">
                    <div class="ui segment">
                        <p>Праздники</p>
                    </div>
                    <div class="ui segment">
                         <p>Праздники</p>
                    </div>
                    <div class="ui segment">
                        <p>Праздники</p>
                    </div>
                    <div class="ui segment">
                         <p>Праздники</p>
                    </div>
                    <div class="ui segment">
                        <p>Праздники</p>
                    </div>                        
                </div>
            </div>
        </div>
        <div class="four wide column">
            <div class="ui raised segments">
                <div class="ui segment">
                    <h4 class="ui header">
                        <i class="checked calendar icon"></i>
                        <div class="content">Выход на работу</div>
                        </h2>
                </div>
                <div class="ui segments">
                    <div class="ui segment">
                        <p>Выход на работу</p>
                    </div>
                    <div class="ui segment">
                        <p>Выход на работу</p>
                    </div>
                    <div class="ui segment">
                        <p>Выход на работу</p>
                    </div>
                    <div class="ui segment">
                        <p>Выход на работу</p>
                    </div>
                    <div class="ui segment">
                        <p>Выход на работу</p>
                    </div>                        
                </div>
            </div>
        </div>
    </div>
</div>



