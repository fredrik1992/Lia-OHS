<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>





<!-- Modal -->

<div class="modal fade" id="testModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Kundvagn</h5>

            </div>
            <div class="modal-body" id="modal-body-cart">
                ...
            </div>
            <div class="modal-footer">
                <form action="<%=request.getContextPath()%>/SaveOrdersController" method="post">
                    <input type="hidden" name="allOrders" id="123" value="test">

                    <button class="btn btn-outline-primary" onclick="saveOrder()" type="submit">Skicka order</button>
                </form>


            </div>
        </div>



    </div>




</div>








