/**
 * Copyright (c) 2018-2028, Chill Zhuang 庄骞 (smallchill@163.com).
 * <p>
 * Licensed under the GNU LESSER GENERAL PUBLIC LICENSE 3.0;
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.gnu.org/licenses/lgpl.html
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.x.core.base.constant;

/**
 * 系统常量
 *
 * @author min-x
 */
public interface MinXConstant {

    /**
     * 编码
     */
    String UTF_8 = "UTF-8";
    /**
     * ContentType
     */
    String CONTENT_TYPE_NAME = "Content-type";
    /**
     * JSON 资源
     */
    String CONTENT_TYPE = "application/json;charset=utf-8";
    /**
     * 默认为空消息
     */
    String DEFAULT_NULL_MESSAGE = "暂无数据";
    /**
     * 默认成功消息
     */
    String DEFAULT_SUCCESS_MESSAGE = "操作成功";
    /**
     * 默认失败消息
     */
    String DEFAULT_FAILURE_MESSAGE = "操作失败";
    /**
     * 默认未授权消息
     */
    String DEFAULT_UNAUTHORIZED_MESSAGE = "签名认证失败";

}
